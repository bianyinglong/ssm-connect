package config;import org.springframework.context.annotation.ComponentScan;import org.springframework.context.annotation.Configuration;import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;import org.springframework.web.servlet.config.annotation.EnableWebMvc;import org.springframework.web.servlet.config.annotation.InterceptorRegistry;import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;/** * 代替SpringMVC的配置文件： * 1、扫描组件   2、视图解析器     3、view-controller    4、default-servlet-handler * 5、mvc注解驱动 */@Configuration@ComponentScan("com.guigu.controller")// 扫描组件@EnableWebMvc // 注解驱动，会与jackson包配合将json字符串转为pojo对象public class SpringMvcConfig implements WebMvcConfigurer {    // 配置开启静态资源    @Override    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {        configurer.enable();    }    /**     * 配置拦截器，暂时用不到     * @param registry     * @return: void     */    @Override    public void addInterceptors(InterceptorRegistry registry) {    }    // 只返回json数据无需配置视图解析器？？？}