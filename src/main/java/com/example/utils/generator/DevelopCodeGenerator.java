package com.example.utils.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 代码生成器配置类
 * @Author demo
 */
public class DevelopCodeGenerator {

	/**添加的模块的名称*/
	private static String moduleName = "杆样式颜色类型";
	/**表名称*/
	private static String tableName = "pole_type";
	/**需要去掉的table前缀*/
	private static String tablePrefix = "";
	/**删除标识，几为有效*/
	private final static Integer STATE = 1;

	/**代码后端生成的地址*/
	private final static String PACKAGE_DIR = System.getProperty("user.dir");
	/**生成到项目中*/
	private final static String OUTPUT_DIR_JAVA = PACKAGE_DIR + "/src/main/java";
	private final static String OUTPUT_DIR_RESOURCES = PACKAGE_DIR + "/src/main/resources";
	/**代码生成的包名*/
	private final static String PACKAGE_NAME ="com.example.analysis";
	/**代码模块包名*/
	private final static String MODULE_PACKAGE_NAME ="";
	/**项目路径*/
	private final static String JAVA_FILE_PATH = OUTPUT_DIR_JAVA + "/" + PACKAGE_NAME.replaceAll("\\.", "/");
	private final static String RESOURCES_FILE_PATH = OUTPUT_DIR_RESOURCES + "/" + PACKAGE_NAME.replaceAll("\\.", "/");

	/**MySQL数据源配置*/
	private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Shanghai&allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=false";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";

	/**数据库模式*/
	private final static String SCHEME_NAME = "demo";

	/**生成的作者*/
	private final static String AUTHOR ="demo";

	/**代码所在服务名*/
	private static String serviceName = "project";
	/**是否包含包装器*/
	private static Boolean hasWrapper = Boolean.FALSE;
	/**是否启用swagger*/
	private static Boolean isSwagger2 = Boolean.TRUE;

	public static void main(String[] args) throws Exception {

		generatorExecute();

		//从这里开始是将模板写入
		//设置类名
		String bigName = getBigName();
		//设置变量名
		String smName = getSmallName();
		// 自动生成文件
		filesGenerator(bigName, smName);
	}

	/**
	 * 自动生成器执行器
	 */
	public static void generatorExecute() {
		AutoGenerator mpg = new AutoGenerator();
//		设置全局配置
		GlobalConfig gc = new GlobalConfig();

		gc.setOpen(false);
		gc.setFileOverride(true);
		gc.setOutputDir(OUTPUT_DIR_JAVA);
		gc.setAuthor(AUTHOR);

//		gc.setOpen(false);
		gc.setActiveRecord(false);
		gc.setEnableCache(false);
		gc.setBaseResultMap(true);
		//设置id默认为雪花算法的id
		gc.setIdType(IdType.ASSIGN_ID);
		gc.setBaseColumnList(true);
		gc.setMapperName("%sMapper");
		gc.setXmlName("%sMapper");
		gc.setServiceName("I%sService");
		gc.setServiceImplName("%sServiceImpl");
		gc.setControllerName("%sController");
		gc.setSwagger2(isSwagger2);
		mpg.setGlobalConfig(gc);
		//设置数据源
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setUrl(URL);
		// dsc.setSchemaName("public");
		dsc.setDriverName(DRIVER_NAME);
		dsc.setUsername(USERNAME);
		dsc.setPassword(PASSWORD);
		dsc.setSchemaName(SCHEME_NAME);
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		// strategy.setCapitalMode(true);// 全局大写命名
		// strategy.setDbColumnUnderline(true);//全局下划线命名
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setSuperServiceClass("com.baomidou.mybatisplus.extension.service.IService");
		strategy.setSuperServiceImplClass("com.baomidou.mybatisplus.extension.service.impl.ServiceImpl");

		// 自定义 controller 父类,策略配置
//		strategy.setSuperControllerClass("org.springblade.core.boot.ctrl.BladeController");
		strategy.setEntityBuilderModel(false);
		strategy.setTablePrefix(tablePrefix);
		strategy.setInclude(tableName);
		strategy.setEntityLombokModel(true);
		//设置逻辑删除
		strategy.setLogicDeleteFieldName("state");
		// 接口设置路径是否有下划线
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setRestControllerStyle(true);
		// 自动填充配置
		TableFill createDate = new TableFill("create_date", FieldFill.INSERT);
		TableFill createUser = new TableFill("create_user", FieldFill.INSERT);
//		TableFill createUsername = new TableFill("createUsername", FieldFill.INSERT);
		TableFill state = new TableFill("state", FieldFill.INSERT);
		TableFill updateDate = new TableFill("update_date", FieldFill.UPDATE);
		TableFill updateUser = new TableFill("update_user", FieldFill.UPDATE);
		List<TableFill> tableFills = new ArrayList<>();
		tableFills.add(createDate);
		tableFills.add(createUser);
		tableFills.add(state);
//		tableFills.add(createUsername);
		tableFills.add(updateDate);
		tableFills.add(updateUser);
		strategy.setTableFillList(tableFills);
		mpg.setStrategy(strategy);
		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setModuleName(MODULE_PACKAGE_NAME);
		pc.setParent(PACKAGE_NAME);
		pc.setController("controller");
		pc.setEntity("entity");
		pc.setMapper("mapper");
		pc.setXml("mapper");
		mpg.setPackageInfo(pc);
		mpg.setCfg(getInjectionConfig());
		mpg.setTemplate(new TemplateConfig().setXml(null));
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}
	private static InjectionConfig getInjectionConfig() {
		// 自定义配置
		List<FileOutConfig> focList = new ArrayList<>();
		focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输入文件名称
				return  getFilepathMap().get("XmlTemplate") + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};
		cfg.setFileOutConfigList(focList);
		return cfg;
	}

	
	/**
	 * 自动生成文件
	 */
	public static void filesGenerator(String bigName, String smName) throws Exception {
		LinkedHashMap<String, String> filepathMap = getFilepathMap();
		// 自动生成文件
		// controller代码生成
		write(filepathMap.get("Controller"), controllerRead(filepathMap.get("Controller"), bigName, smName));
		// service代码生成
		write(filepathMap.get("Service"), serviceRead(filepathMap.get("Service"), bigName, smName));
		// serviceImpl代码生成
		write(filepathMap.get("ServiceImpl"), serviceImplRead(filepathMap.get("ServiceImpl"), bigName, smName));
		// entity 代码生成
		write(filepathMap.get("Entity"), entityRead(filepathMap.get("Entity"), bigName, smName));
		// mapper代码生成
		write(filepathMap.get("Mapper"), mapperRead(filepathMap.get("Mapper"), bigName, smName));
		// xml代码生成
		write(filepathMap.get("Xml"), xmlRead(filepathMap.get("Xml"), bigName, smName));

		// 自定义生成文件
		// Converter代码生成(要先创建文件)
		converterGenerator(filepathMap.get("Converter"), bigName);
		// Query代码生成(要先创建文件)
		paramsGenerator(filepathMap.get("Param"), bigName);
		// Vo代码生成(要先创建文件)
		voGenerator(filepathMap.get("Vo"), bigName);
	}
	/**
	 * Controller代码生成
	 * @param filePath 文件路径
	 * @param bigName 类名
	 * @return 自动生成的代码
	 * @throws Exception
	 */
	public static String controllerRead(String filePath, String bigName, String smName) throws Exception {
		BufferedReader br = null;
		String line;
		StringBuilder buf = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(filePath));
			while (null != (line=br.readLine())){
				if (line.contains("package")){
					buf.append(line).append("\n\n")
							.append("import " + PACKAGE_NAME + ".dao.params.").append(bigName).append("Param;\n")
							.append("import " + PACKAGE_NAME + ".service.I").append(bigName).append("Service;\n")
							.append("import " + PACKAGE_NAME + ".dao.vo.").append(bigName).append("Vo;\n")
							.append("import com.example.support.PageResult;\n")
							.append("import com.example.support.Result;\n")
							.append("import com.example.support.enums.BizErrorCodeEnum;\n")
							.append("import io.swagger.annotations.Api;\n")
							.append("import io.swagger.annotations.ApiImplicitParam;\n")
							.append("import io.swagger.annotations.ApiOperation;\n")
							.append("import io.swagger.annotations.ApiParam;\n")
							.append("import org.slf4j.Logger;\n")
							.append("import org.slf4j.LoggerFactory;\n")
							.append("import org.springframework.beans.factory.annotation.Autowired;\n")
							.append("import org.springframework.web.bind.annotation.*;\n\n")
							.append("import java.util.List;\n");
				}else if (line.contains("@RequestMapping")){
					buf
							.append(line.substring(0,1).replace("@", "@RequestMapping(\"/" + smName + "\")"))
							.append("\n@Api(value =\"").append(moduleName).append("\", tags = \"").append(moduleName).append("管理").append("\")\n");
				}else if (line.contains("{")){
					buf.append(line).append("\n\n")
							.append("\tpublic final static Logger logger = LoggerFactory.getLogger(").append(bigName).append("Controller.class);\n\n")
							.append("\t@Autowired\n")
							.append("\tI").append(bigName).append("Service  ").append(smName).append("Service;\n\n")
							// 分页
							.append("\t@PostMapping(value =\"/page\", produces = \"application/json;charset=UTF-8\")\n")
							.append("\t@ApiOperation(value = \"分页").append(moduleName).append("\", notes = \"分页").append(moduleName).append("\")\n")
							.append("\tpublic Result<PageResult<").append(bigName).append("Vo>> page").append(bigName).append("(@RequestBody @ApiParam(name = \"传入json格式").append("\",\n")
							.append("\t\t\tvalue = \"参数：\", required = true) ").append(bigName).append("Param param){\n")
							.append("\t\ttry {\n")
							.append("\t\t\treturn Result.success(").append(smName).append("Service.page").append(bigName).append("Vo(param));\n")
							.append("\t\t} catch (Exception e) {\n")
							.append("\t\t\tlogger.error(\"分页").append(moduleName).append("失败\", e);\n")
							.append("\t\t\treturn Result.error(BizErrorCodeEnum.BIZ_UNKNOWN_EXCEPTION);\n")
							.append("\t\t}\n")
							.append("\t}\n\n");

//					//添加
//					buf.append("\t@PostMapping(value =\"/add\")\n")
//							.append("\t@ApiOperation(value = \"添加").append(moduleName).append("\", notes = \"添加").append(moduleName).append("\")\n")
//							.append("\tpublic BaseResponse<").append(bigName).append("> add").append(bigName).append("(@RequestBody ")
//							.append(bigName).append(" ").append(smName).append("){\n" +
//							"\t    return ").append(smName).append("Service.add").append(smName).append("(").append(smName).append(");\n    }\n\n");
//					//编辑
//					buf.append("\t@PostMapping(value =\"/update\")\n")
//							.append("\t@ApiOperation(value = \"编辑").append(moduleName).append("\", notes = \"编辑").append(moduleName).append("\")\n")
//							.append("\tpublic BaseResponse<Integer> update").append(bigName).append("(@RequestBody ")
//							.append(bigName).append(" ").append(smName).append("){\n" +
//							"\t    return ").append(smName).append("Service.update").append(smName).append("(").append(smName).append(");\n    }\n\n");
//					//删除
//					buf.append("\t@GetMapping(value =\"/delete\")\n")
//							.append("\t@ApiOperation(value = \"删除").append(moduleName).append("\", notes = \"删除").append(moduleName).append("\")\n")
//							.append("\tpublic BaseResponse<Integer> delete").append(bigName).append("(@RequestParam String id){\n" +
//							"\t    return ").append(smName).append("Service.delete").append(smName).append("(id);\n    }\n\n");
//					//详情
//					buf.append("\t@GetMapping(value =\"/view/{id}\")\n")
//							.append("\t@ApiOperation(value = \"").append(moduleName).append("详情\", notes = \"").append(moduleName).append("详情\")\n")
//							.append("\tpublic BaseResponse<").append(bigName).append("> view").append(bigName).append("(@PathVariable String id){\n" +
//							"\t    return ").append(smName).append("Service.view").append(smName).append("(id);\n    }\n\n");
//					//分页
//					buf.append("\t@GetMapping(value =\"/page\")\n")
//							.append("\t@ApiOperation(value = \"").append(moduleName).append("分页\", notes = \"").append(moduleName).append("分页\")\n")
//							.append("\tpublic BaseResponse<PageDTO<").append(bigName).append("DTO>> page").append(bigName).append("(")
//							.append(bigName).append("Query ").append(smName).append("Query){\n" +
//							"\t    return ").append(smName).append("Service.page").append(smName).append("(").append(smName).append("Query);\n    }\n\n");

				}
				else{
					buf.append(line).append("\n");
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			if (br != null) {
				br.close();
			}
		}
		return buf.toString();
	}
	/**
	 * Service代码生成
	 * @param filePath 文件路径
	 * @param bigName 类名
	 * @return 自动生成的代码
	 * @throws Exception
	 */
	public static String serviceRead(String filePath, String bigName, String smName) throws Exception {
		BufferedReader br = null;
		String line;
		StringBuilder buf = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(filePath));
			while (null != (line=br.readLine())){
				if (line.contains("package")){
					buf.append(line).append("\n\n")
							.append("import " + PACKAGE_NAME + ".dao.params.").append(bigName).append("Param;\n")
							.append("import " + PACKAGE_NAME + ".dao.vo.").append(bigName).append("Vo;\n")
							.append("import com.example.support.PageResult;\n");
				}
				else if (line.contains("{")){
					buf.append(line).append("\n\n")
							// 分页
							.append("\t/**\n")
							.append("\t * ").append(moduleName).append("分页\n")
							.append("\t */\n")
							.append("\tPageResult<").append(bigName).append("Vo> page").append(bigName).append("Vo(").append(bigName).append("Param param);\n");

					// 可增加
				}
				else{
					buf.append(line).append("\n");
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return buf.toString();
	}
	/**
	 * ServiceImpl代码生成
	 * @param filePath 文件路径
	 * @param bigName 类名
	 * @return 自动生成的代码
	 * @throws Exception
	 */
	public static String serviceImplRead(String filePath, String bigName, String smName) throws Exception {
		BufferedReader br = null;
		String line;
		StringBuilder buf = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(filePath));
			while (null != (line=br.readLine())){
				if (line.contains("package")){
					buf.append(line).append("\n\n")
							.append("import " + PACKAGE_NAME + ".dao.converter.I").append(bigName).append("Converter;\n")
							.append("import " + PACKAGE_NAME + ".dao.params.").append(bigName).append("Param;\n")
							.append("import " + PACKAGE_NAME + ".dao.vo.").append(bigName).append("Vo;\n")
							.append("import com.example.support.AppPage;\n")
							.append("import com.example.support.PageResult;\n")
							.append("import java.util.List;\n");
				}
				else if (line.contains("{")){
					//查詢
					buf.append(line).append("\n\n")
							// 分页
							.append("\t/**\n")
							.append("\t * ").append(moduleName).append("分页\n")
							.append("\t */\n")
							.append("\t@Override\n")
							.append("\tpublic PageResult<").append(bigName).append("Vo> page").append(bigName).append("Vo(").append(bigName).append("Param param) {\n")
							.append("\t\tAppPage<").append(bigName).append("Vo> appPage = new AppPage<>(param);\n")
							.append("\t\tList<").append(bigName).append("> entityList = this.lambdaQuery().page(new AppPage<>(param)).getRecords();\n")
							.append("\t\tappPage.setRecords(I").append(bigName).append("Converter.INSTANCE.toVoList(entityList));\n")
							.append("\t\treturn new PageResult<>(appPage);\n")
							.append("\t}\n\n");
				
					// 可增加
				}
				else{
					buf.append(line).append("\n");
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return buf.toString();
	}
	/**
	 * entity代码生成
	 * @param filePath 文件路径
	 * @param bigName 类名
	 * @return 自动生成的代码
	 * @throws Exception
	 */
	public static String entityRead(String filePath, String bigName, String smName) throws Exception {
		BufferedReader br = null;
		String line;
		StringBuilder buf = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(filePath));
			while (null != (line=br.readLine())){
				if (line.contains("@TableLogic")){
					buf.append("\t@TableLogic(value = \"").append(STATE).append("\",delval = \"").append(1-STATE).append("\")\n");
				}
				else{
					buf.append(line).append("\n");
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}  finally {
			if (br != null) {
				br.close();
			}
		}
		return buf.toString();
	}
	/**
	 * mapper代码生成
	 * @param filePath 文件路径
	 * @param bigName 类名
	 * @return 自动生成的代码
	 * @throws Exception
	 */
	public static String mapperRead(String filePath, String bigName, String smName) throws Exception {
		BufferedReader br = null;
		String line;
		StringBuilder buf = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(filePath));
			while (null != (line=br.readLine())){
				if (line.contains("package")){
					buf.append(line).append("\n\n")
							.append("import " + PACKAGE_NAME + ".dao.params.").append(bigName).append("Param;\n")
							.append("import com.example.support.AppPage;\n")
							.append("import org.apache.ibatis.annotations.Param;\n\n")
							.append("import java.util.List;\n");
				}else if (line.contains("{")){
					//查询
					buf.append(line).append("\n\n")
							// 分页
							.append("\t/**\n")
							.append("\t * ").append(moduleName).append("分页\n")
							.append("\t */\n")
							.append("\tList<").append(bigName).append("> pageByParam(AppPage<").append(bigName).append("> appPage, @Param(\"param\") ").append(bigName).append("Param param);\n");
				}
				else{
					buf.append(line).append("\n");
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return buf.toString();
	}
	/**
	 * xml代码生成
	 * @param filePath 文件路径
	 * @param bigName 类名
	 * @return 自动生成的代码
	 * @throws Exception
	 */
	public static String xmlRead(String filePath, String bigName, String smName) throws Exception {
		BufferedReader br = null;
		String line;
		StringBuilder buf = new StringBuilder();
		try {
			br = new BufferedReader(new FileReader(filePath));
			while (null != (line=br.readLine())){
				if (line.contains("</resultMap>")){
					buf.append(line).append("\n    <resultMap id=\"BaseResultMapVo\" type=\"").append(PACKAGE_NAME)
							.append(".dao.vo.").append(bigName).append("Vo\">\n\n");
				}if (line.contains("</sql")){
					// 查詢
					buf.append(line).append("\n\n")
							// 分页
							.append("\t<!--  分页查詢").append(moduleName).append("  -->\n")
							.append("\t<select id=\"pageByParam\" resultMap=\"BaseResultMap\">\n")
							.append("\t\tSELECT <include refid=\"Base_Column_List\"/>\n")
							.append("\t\tFROM " + SCHEME_NAME + ".").append(tableName).append("\n")
							.append("\t</select>\n");
				} else{
					buf.append(line).append("\n");
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return buf.toString();
	}


	// 自定义文件生成
	/**
	 * Converter代码生成
	 * @param filePath 文件路径
	 * @param bigName 类名
	 */
	public static void converterGenerator(String filePath, String bigName) {
		try {
			String converter = "package " + PACKAGE_NAME + ".dao.converter;\n\n" +
					"import " + PACKAGE_NAME + ".dao.vo." + bigName + "Vo;\n" +
					"import " + PACKAGE_NAME + ".entity." + bigName + ";\n" +
					"import io.swagger.annotations.ApiModel;\n" +
					"import org.mapstruct.Mapper;\n" +
					"import org.mapstruct.factory.Mappers;\n\n" +
					"import java.util.List;\n\n" +
					"/**\n" + " * @Author: " + AUTHOR + "\n * @Date: " + LocalDateTime.now() + "\n */\n" +
					"@ApiModel(value=\"" + bigName + "Converter\", description=\"" +
					moduleName + "转换器\")\n@Mapper(componentModel = \"Spring\")\npublic interface I" + bigName + "Converter {\n\n" +
					"\tI" + bigName + "Converter" + " INSTANCE = Mappers.getMapper(I" +
					bigName + "Converter.class);\n\n" +
					"\t" + bigName + "Vo toVo(" + bigName + " entity);\n\n" +
					"\tList<" + bigName + "Vo> toVoList(List<" + bigName + "> " + "entityList);\n\n}";
			if (mkdir(filePath)) {
				write(filePath, converter);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Query代码生成
	 * @param filePath 文件路径
	 * @param bigName 类名
	 */
	public static void paramsGenerator(String filePath, String bigName) {
		try {
			String query = "package " + PACKAGE_NAME + ".dao.params;\n\n" +
					"import com.example.support.PageParam;\n" +
					"import io.swagger.annotations.ApiModel;\n" +
					"import io.swagger.annotations.ApiModelProperty;\n" +
					"import lombok.Data;\n" +
					"import lombok.EqualsAndHashCode;\n\n" +
					"/**\n * @Author: " + AUTHOR + "\n * @Date: " + LocalDateTime.now() + "\n */\n" +
					"@Data\n" +
					"@EqualsAndHashCode(callSuper = true)\n" +
					"@ApiModel(value=\"" + bigName + "Param\", description=\"" + moduleName + "传参对象\")\n" +
					"public class " + bigName + "Param extends PageParam {\n\n}";
			if (mkdir(filePath)) {
				write(filePath, query);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Vo代码生成
	 * @param filePath 文件路径
	 * @param bigName 类名
	 */
	public static void voGenerator(String filePath, String bigName) {
		try {
			String vo = "package " + PACKAGE_NAME + ".dao.vo;\n\n" +
					"import io.swagger.annotations.ApiModel;\n" +
					"import io.swagger.annotations.ApiModelProperty;\n" +
					"import lombok.Data;\n" +
					"import lombok.EqualsAndHashCode;\n\n" +
					"/**\n * @Author: " + AUTHOR + "\n * @Date: " + LocalDateTime.now() + "\n */\n" +
					"@Data\n" +
					"@EqualsAndHashCode()\n" +
					"@ApiModel(value=\"" + bigName + "Vo\", description=\"" + moduleName + "Vo对象\")\n" +
					"public class " + bigName + "Vo {\n\n}";
			if (mkdir(filePath)) {
				write(filePath, vo);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}


	private static String getBigName() {
		//获取去掉前缀后的
		String trueName="";
		if (tableName.substring(0,tablePrefix.length()).equals(tablePrefix)){
			trueName= tableName.substring(tablePrefix.length());
		}else {
			trueName= tableName;
		}
		String[] before=trueName.split("_");
		//设置类名
		StringBuilder bigName = new StringBuilder();
		for (String s : before) {
			if (StringUtils.isNotEmpty(s)) {
				bigName.append(s.substring(0, 1).toUpperCase(Locale.ROOT)).append(s.substring(1).toLowerCase(Locale.ROOT));
			}
		}
		return bigName.toString();
	}

	private static String getSmallName() {
		String bigName = getBigName();
		if (StringUtils.isEmpty(bigName)) { return null; }
		return bigName.substring(0,1).toLowerCase(Locale.ROOT)+bigName.substring(1);
	}

	private static LinkedHashMap<String, String> getFilepathMap() {
		LinkedHashMap<String, String> filepathMap = new LinkedHashMap<>();
		String bigName = getBigName();
		// 自动生成文件
		filepathMap.put("Controller", JAVA_FILE_PATH + "/controller/" + bigName + "Controller.java");
		filepathMap.put("Service", JAVA_FILE_PATH + "/service/I" + bigName + "Service.java");
		filepathMap.put("ServiceImpl", JAVA_FILE_PATH + "/service/impl/" + bigName + "ServiceImpl.java");
		filepathMap.put("Entity", JAVA_FILE_PATH + "/entity/" + bigName + ".java");
		filepathMap.put("Mapper", JAVA_FILE_PATH + "/mapper/" + bigName + "Mapper.java");
		filepathMap.put("XmlTemplate", RESOURCES_FILE_PATH + "/mapper/");
		filepathMap.put("Xml", RESOURCES_FILE_PATH + "/mapper/" + bigName + "Mapper.xml");
		// 自定义生成文件
		filepathMap.put("Converter", JAVA_FILE_PATH + "/dao/converter/" + "I" + bigName + "Converter.java");
		filepathMap.put("Param", JAVA_FILE_PATH + "/dao/params/" + bigName + "Param.java");
		filepathMap.put("Vo", JAVA_FILE_PATH + "/dao/vo/" + bigName + "Vo.java");
		return filepathMap;
	}

	/**
	 * 写入模板
	 * @param filePath
	 * @param content
	 * @throws IOException
	 */
	public static void write(String filePath, String content) throws IOException {
		try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(filePath))){
			bufferedWriter.write(content);
		}
	}
	public static boolean mkdir(String filepath) {
		File folder = new File(filepath.substring(0, filepath.lastIndexOf("/")));
		if (!folder.exists() && !folder.isDirectory()) {
			return folder.mkdirs();
		}
		return true;
	}
}
