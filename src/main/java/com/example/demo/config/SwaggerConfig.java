package com.example.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Documentation;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.WebMvcRequestHandler;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("SwaggerUI API")
                .description("demo")
                .version("0.1")
                .build();
    }
    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor(){
        return new BeanPostProcessor() {
            private List<RequestMappingInfoHandlerMapping> getHandlerMapper(Object bean) {
                try{
                   Field field= ReflectionUtils.findField(bean.getClass(),"handlerMappings");
                   field.setAccessible(true);
                   return (List<RequestMappingInfoHandlerMapping>)field.get(bean);
                }catch(IllegalArgumentException |IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if(bean instanceof WebMvcRequestHandlerProvider||bean instanceof WebMvcRequestHandlerProvider){
                    customizeSpringfoxHandlerMappings(getHandlerMapper(bean));
                }
                return bean;
            }
            @SuppressWarnings("unchecked")
            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings){
                List copy=mappings.stream()
                        .filter(item->item.getPatternParser()==null)
                        .collect(Collectors.toList());
                mappings.clear();
                mappings.addAll(copy);
            }
        };
    }
}
