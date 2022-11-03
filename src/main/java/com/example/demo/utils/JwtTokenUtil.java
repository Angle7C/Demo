package com.example.demo.utils;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import com.example.demo.entity.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.JwtSignatureValidator;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;


@Component
@Slf4j
@Getter
public class JwtTokenUtil {
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    private static JWTSigner jwtSigner;
    @Value("${secretJWT}")
    private  String secret;
    @Value("${expirationJWT}")
    private  Long expiration;
    @PostConstruct
    public void  init(){
        jwtSigner = JWTSignerUtil.hs512(secret.getBytes());
    }
    /**
     * @param claims 载荷的内容
     * @return Token 值
     */
    private  String generateToken(Map<String, Object> claims) {
        return  JWT.create()
                .setExpiresAt(DateUtil.date(getExpiration()))
                .addPayloads(claims)
                .setSigner(jwtSigner)
                .sign();
    }

    /**
     * @param token JWT Token
     * @return 返回载荷
     */
    private  JWTPayload getClaimsFromToken(String token) {
        JWTPayload payload=null;
        try {
            payload = getJWT(token).getPayload();
        } catch (Exception e) {
            log.info("JWT格式错误:{}", token);
        }
        return payload;
    }

    /**
     * @return 过期时间
     */
    private  Date generateExpirationDate() {

        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * @param token JWT token
     * @return 用户名
     */
    public  String getUserNameFromToken(String token) {
        String username = "";
        try {
             JWTPayload jwtPayload= getClaimsFromToken(token);
             username = (String) jwtPayload.getClaim("username");
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    private JWT getJWT(String token){
            return JWT.create().setSigner(jwtSigner).parse(token);
    }
    /**
     * @param token       JWT token
     * @param userDetails Spring Security 封装的用户信息
     * @return 验证token是否有效
     */
    public  boolean validateToken(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername());
    }

    /**
     * token是否过期
     *
     * @param token JWT Token
     * @return bool
     */
    private  boolean isTokenExpired(String token) {
        try{
            JWTValidator jwtValidator = JWTValidator.of(getJWT(token)).validateDate(DateUtil.date());
        }catch (Exception e){
            return  true;
        }
        return false;
    }

    /**
     * 是否可以更新token
     *
     * @param token JWT Token
     * @return boolean
     */
    public   boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }

    /**
     * 更新过期时间
     *
     * @param token JWT Token
     * @return 新的JWT
     */
    public  String refreshToken(String token) {
        String tokenNew=null;
        if (!isTokenExpired(token)){
            return getJWT(token).setExpiresAt(DateUtil.date(getExpiration())).sign();
        }else{
            return null;
        }
    }
    public String getToken(User user){
//            user.getUserName();
            //TODO 获取该角色的授权。
            return null;
    }
}
