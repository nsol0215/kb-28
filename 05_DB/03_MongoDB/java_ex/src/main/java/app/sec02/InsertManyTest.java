package app.sec02;

import app.sec01.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class InsertManyTest {
    public static void main(String[] args) {

        // Database 유틸리티 클래스를 이용해서 study 컬렉션(테이블) 연결 객체 얻어오기
        MongoCollection<Document> collection = Database.getCollection("study");

        // 문서 리스트 객체 생성
        List<Document> insertList = new ArrayList<>();

        Document document1 = new Document();
        document1.append("title","Dune2 영화보기");
        document1.append("desc","이번 주말IMAX로Dune2 영화보기");
        document1.append("done","false");

        Document document2 = new Document();
        document2.append("title","Java MongoDB 연동");
        document2.append("desc","Java로 MongoDB 연동 프로그래밍 연습하기");
        document2.append("done","true");

        // 문서 리스트에 추가
        insertList.add(document1);
        insertList.add(document2);

        // 한 번에 insert
        InsertManyResult result = collection.insertMany(insertList);

        // 생성된 문서의 _id 필드 값 얻어오기
        System.out.println("InsertOneResult : " + result.getInsertedIds());

        // 데이터베이스 연결 종료 및 리소스 정리
        Database.close();
    }
}
