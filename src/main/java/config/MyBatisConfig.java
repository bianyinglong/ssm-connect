package config;import com.github.pagehelper.PageHelper;import com.github.pagehelper.PageInterceptor;import org.apache.ibatis.logging.log4j.Log4jImpl;import org.apache.ibatis.plugin.Interceptor;import org.apache.ibatis.session.Configuration;import org.mybatis.spring.SqlSessionFactoryBean;import org.mybatis.spring.mapper.MapperScannerConfigurer;import org.springframework.context.annotation.Bean;import org.springframework.core.io.support.PathMatchingResourcePatternResolver;import javax.sql.DataSource;import java.io.IOException;import java.util.Properties;public class MyBatisConfig {    /**     * 下面两个方法相当于spring.xml中的如下配置     * mybatis配置     * <bean class="org.mybatis.spring.SqlSessionFactoryBean" id="sqlSessionFactory">     * <property name="dataSource" ref="dataSource"/>     * <property name="mapperLocations" value="classpath:mapper/*.xml"/>     * </bean>     * 自动扫描mapper接口     * <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">     * <property name="basePackage" value="com.lin.mapper"/>     * </bean>     */    @Bean    public PageHelper pageHelper() {        PageHelper pageHelper = new PageHelper();        Properties p = new Properties();        //设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用        p.setProperty("offsetAsPageNum", "true");        //设置为true时，使用RowBounds分页会进行count查询        p.setProperty("rowBoundsWithCount", "true");        p.setProperty("reasonable", "true");        pageHelper.setProperties(p);        return pageHelper;    }    // DataSource dataSource 来自于ioc容器    @Bean    public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource) throws IOException {        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();        factoryBean.setDataSource(dataSource);        PathMatchingResourcePatternResolver resolve = new PathMatchingResourcePatternResolver();        // 1.加载mapper.xml文件        // 使用classpath:表示从类路径查找配置文件，例如maven工程中的src/main/resources        // 📢：是getResources，别漏掉了s        factoryBean.setMapperLocations(resolve.getResources("classpath:**/mapper/*.xml"));        // setTypeAliasesPackage自动设置别名（暂不需要），这样 parameterType="com.guigu.mybatis.pojo.DeptExample" 可以直接简写为DeptExample        factoryBean.setTypeAliasesPackage("com.guigu.mybatis.pojo");        // 配置log4j        Configuration configuration = new Configuration();        configuration.setLogImpl(Log4jImpl.class);        factoryBean.setConfiguration(configuration);        // 配置分页插件        PageInterceptor pageInterceptor = new PageInterceptor();        // 要为pageInterceptor设置properties，否则会报空指针异常        Properties properties = new Properties();        pageInterceptor.setProperties(properties);//        factoryBean.setPlugins(new Interceptor[]{pageInterceptor});        factoryBean.setPlugins(pageInterceptor);        return factoryBean;    }    // 2. 自动扫描mapper接口    @Bean    public MapperScannerConfigurer getMapperScannerConfigurer() {        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();        mapperScannerConfigurer.setBasePackage("com.guigu.mapper");        return mapperScannerConfigurer;    }}