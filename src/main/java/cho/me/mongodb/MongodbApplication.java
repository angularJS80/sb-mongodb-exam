package cho.me.mongodb;

import cho.me.mongodb.dto.Meeting;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongodbApplication {

	@Autowired
	MongoDbFactory mongoDbFactory;

	@Autowired
	MongoTemplate mongoTemplate;
	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner(){



		return args -> {
			MongoDatabase md =  mongoDbFactory.getDb();
			md.createCollection("sbtry");
			md.getCollection("sbtry").insertOne(
					new Document()
							.append("target","there")
							.append("title","factory study")

			);

		Meeting meeting = new Meeting();
		meeting.setTarget("here");
		meeting.setTitle("study");
		mongoTemplate.insert(meeting);
		};



	}
}

