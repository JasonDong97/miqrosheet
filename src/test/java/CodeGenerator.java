import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;

public class CodeGenerator {

    public static void main(String[] args) {
        String module = ".";
        String packageName = "com.era.miqrosheet";
        FastAutoGenerator.create("jdbc:mysql://10.36.160.33:3306/miqrosheet", "root", "EybTcTBcJCdjwOFh")
                .globalConfig(builder -> {
                    builder.author("dongjingxiang") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(module + "\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> builder
                        .parent(packageName)
                        .moduleName("domain")
                        .service("service")
                        .serviceImpl("service.impl")
                        .entity("model")
                        .mapper("mapper")
                        .xml("mapper")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, module + "\\src\\main\\resources\\mapper"))
                )
                .strategyConfig(builder -> builder
                        .addInclude("wb", "wb_sheet", "wb_sheet_celldata") // 设置需要生成的表名
                        .controllerBuilder().disable()
                        .entityBuilder()
                        .enableLombok()
                        .addTableFills(new Column("create_time", FieldFill.INSERT))
                        .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
