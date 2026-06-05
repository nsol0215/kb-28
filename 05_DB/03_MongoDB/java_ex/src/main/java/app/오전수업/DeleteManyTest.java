package app.오전수업;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.*;

public class DeleteManyTest {
    public static void main(String[] args) {
        //Database클래스를 쓰는 순간 static{ }이 실행이 됨.db서버연결, db연결이 준비가 됨.
        MongoCollection<Document> collection = Database.getCollection("users");
        System.out.println("3. todo 컬렉션 연결 성공.");

        // 업데이트할 때, 조건을 만족하는 document를 찾아서 키를 수정함
        Bson query = gt("age", 15);
        DeleteResult result = collection.deleteMany(query);
        System.out.println(result);

        Database.close();
    }
}