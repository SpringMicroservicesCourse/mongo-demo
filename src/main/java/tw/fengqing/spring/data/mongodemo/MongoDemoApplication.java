package tw.fengqing.spring.data.mongodemo;

import com.mongodb.client.result.UpdateResult;
import tw.fengqing.spring.data.mongodemo.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@SpringBootApplication
@Slf4j
public class MongoDemoApplication implements ApplicationRunner {
	@Autowired
	private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}



	@Override
	public void run(ApplicationArguments args) throws Exception {
		Coffee espresso = Coffee.builder()
				.name("espresso")
				.price(Money.of(CurrencyUnit.of("TWD"), 100.0))
				.createTime(new Date())
				.updateTime(new Date()).build();
		Coffee saved = mongoTemplate.save(espresso);
		log.info("Coffee {}", saved);

		List<Coffee> list = mongoTemplate.find(
				Query.query(Criteria.where("name").is("espresso")), Coffee.class);
		log.info("Find {} Coffee", list.size());
		list.forEach(c -> log.info("Coffee {}", c));

		Thread.sleep(1000); // 為了看更新時間
		UpdateResult result = mongoTemplate.updateFirst(query(where("name").is("espresso")),
				new Update().set("price", Money.ofMajor(CurrencyUnit.of("TWD"), 150))
						.currentDate("updateTime"),
				Coffee.class);
		log.info("Update Result: {}", result.getModifiedCount());
		Coffee updateOne = mongoTemplate.findById(saved.getId(), Coffee.class);
		log.info("Update Result: {}", updateOne);

		// 刪除此筆資料
		mongoTemplate.remove(updateOne);
	}
}

