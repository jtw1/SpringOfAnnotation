package exercise.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Description
 * @date 2021/1/19-19:50
 */
public class MyTypeFilter implements TypeFilter {
    @Override
    /**
     * metadataReader：读取到正在扫描的类的信息
     * metadataReaderFactory  可以获取到其他类的信息
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类的资源
        Resource resource = metadataReader.getResource();
        System.out.println("--->"+classMetadata.getClassName());
        if(classMetadata.getClassName().contains("er")){
            return true;
        }
        return false;
    }
}
