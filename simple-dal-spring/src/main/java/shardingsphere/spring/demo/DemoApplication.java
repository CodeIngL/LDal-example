package shardingsphere.spring.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletException;

/**
 * @author
 * @date
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(value = "shardingsphere.spring.demo")
@PropertySource(value = {"classpath:application-dal.properties"})
@PropertySource(value = {"classpath:application.properties"})
@ImportResource(value = {"classpath:app.xml"})
@EnableWebMvc
public class DemoApplication extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DemoApplication.class};
    }
}
