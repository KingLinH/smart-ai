package com.kinglin.smart.ai;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.ClassPathDocumentLoader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author HJinLin
 * @description RAG
 * @date 2025-06-21 14:18
 */
@SpringBootTest
public class RAGTest {

    @Test
    public void test() {
        //使用FileSystemDocumentLoader读取指定目录下的知识库文档;ClassPathDocumentLoader
        //并使用默认的文档解析器TextDocumentParser对文档进行解析
        Document document = ClassPathDocumentLoader.loadDocument("测试.txt");
        System.out.println(document.text());
    }

}
