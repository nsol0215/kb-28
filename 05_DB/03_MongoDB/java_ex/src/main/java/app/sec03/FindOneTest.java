package app.sec03;

import app.sec01.Database;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.*;
// import static : 클래스명을 생략하고 메소드명만 작성 가능

public class FindOneTest {
    public static void main(String[] args) {

        // Database 유틸리티 클래스를 이용해서 study 컬렉션(테이블) 연결 객체 얻어오기
        MongoCollection<Document> collection = Database.getCollection("study");

        // 존재하는 _id
        String id = "6a22670e34286d1e6dd66388";

        // Filters.eq()
        Bson query = eq("_id", new ObjectId(id));

        // 조건을 만족하는 결과 중 1행(문서 1개)만 조회
        // collection.find() == db.study.find()
        Document doc = (Document) collection.find(query).first();

        System.out.println("FindByIdResult : " + doc);

        Database.close();

    }
}
