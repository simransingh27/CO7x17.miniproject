package miniproject1.mongoDb

import com.mongodb.BasicDBObject
import com.mongodb.DBCollection
import com.mongodb.DBObject

import groovy.json.JsonSlurper
import org.apache.catalina.mapper.MappingData
import miniproject1.mongoDb.PersonsData

class BulkTransfer {
	static void main(String... args) {

		MongoDB mongo = new MongoDB()
		JsonSlurper slurper = new JsonSlurper()
		def friends = slurper.parseText(new File('./src/main/resources/twitter/friends.json').text)
		def followers = slurper.parseText(new File('./src/main/resources/twitter/followers.json').text)
		def tweets = slurper.parseText(new File('./src/main/resources/twitter/tweets.json').text)
		mongo.initDb()
		
		DBCollection collection = mongo.db.getCollection("followers")//instance mongo table followers
		DBCollection collection01 = mongo.db.getCollection("friends") //instance of mongo table friends
		PersonsData md =  new PersonsData()

		followers.users.each {follower ->  // iterating over followers  using a closure follower

			DBObject dbobject = new BasicDBObject()// creating BasicDBobject every time the loop runs
			dbobject.put("id_string",md.id_str = follower.id_str )
			dbobject.put("name",md.name =  follower.name)
			dbobject.put("description",md.description =  follower.descrption)
			dbobject.put("favorites_count", md.favorites_count =  follower.favorites_count)
			dbobject.put("followers_count",md.followers_count = follower.friends_count)
			dbobject.put("friends_count",md.friends_count = follower.friends_count)
			dbobject.put("location",md.location = follower.location)
			dbobject.put("screen_name",md.screen_name = follower.screen_name)
			dbobject.put("url",md.url = follower.url)
			dbobject.put("created_at", md.created_at = follower.created_at )
			tweets.findAll({tweet ->    // find in table tweets
				(tweet.user != null) && (tweet.user.id == follower.id) // if this condition satisfies
				dbobject.put("id_string01",md.id_str01 = tweet.id_str )
				dbobject.put("created_at01",md.created_at01 =  tweet.created_at)
				dbobject.put("description",md.entities =  tweet.entities)
				dbobject.put("favorite_count", md.favorite_count =  tweet.favorite_count)
				dbobject.put("favorited",md.favorited = tweet.favorited)
				dbobject.put("user_id_str",md.user_id_str = tweet.id_str)
				dbobject.put("in_reply_to_screen_name",md.in_reply_to_screen_name = tweet.in_reply_to_screen_name)
				dbobject.put("in_reply_to_status_id",md.screen_name = tweet.in_reply_to_status_id)
				dbobject.put("in_reply_to_user_id",md.in_reply_to_user_id = tweet.in_reply_to_user_id)
				dbobject.put("language_code", md.language_code = tweet.language_code )
				dbobject.put("retweet_count",md.retweet_count = tweet.retweet_count )
				dbobject.put("retweeted",md.retweeted =  tweet.retweeted)
				dbobject.put("source",md.source =  tweet.source)
				dbobject.put("text", md.text =  tweet.text)
				dbobject.put("lang",md.lang = tweet.lang)
				collection.insert(dbobject)
			})
		}

		friends.users.each {friend ->// iterating over friends  using a closure follower
			DBObject dbobject01 = new BasicDBObject() //creating basic db object
			dbobject01.put("id_string",md.id_str = friend.id_str )
			dbobject01.put("name",md.name =  friend.name)
			dbobject01.put("description",md.description =  friend.descrption)
			dbobject01.put("favorites_count", md.favorites_count = friend.favorites_count)
			dbobject01.put("followers_count",md.followers_count = friend.friends_count)
			dbobject01.put("friends_count",md.friends_count = friend.friends_count)
			dbobject01.put("location",md.location = friend.location)
			dbobject01.put("screen_name",md.screen_name = friend.screen_name)
			dbobject01.put("url",md.url = friend.url)
			dbobject01.put("created_at", md.created_at = friend.created_at )
			tweets.findAll({tweet -> // find i table tweets
				(tweet.user != null) && (tweet.user.id == friend.id)// if this condition satisfies
				dbobject01.put("id_string01",md.id_str01 = tweet.id_str )
				dbobject01.put("created_at01",md.created_at01 =  tweet.created_at)
				dbobject01.put("description",md.entities =  tweet.entities)
				dbobject01.put("favorite_count", md.favorite_count =  tweet.favorite_count)
				dbobject01.put("favorited",md.favorited = tweet.favorited)
				dbobject01.put("user_id_str",md.user_id_str = tweet.id_str)
				dbobject01.put("in_reply_to_screen_name",md.in_reply_to_screen_name = tweet.in_reply_to_screen_name)
				dbobject01.put("in_reply_to_status_id",md.screen_name = tweet.in_reply_to_status_id)
				dbobject01.put("in_reply_to_user_id",md.in_reply_to_user_id = tweet.in_reply_to_user_id)
				dbobject01.put("language_code", md.language_code = tweet.language_code )
				dbobject01.put("retweet_count",md.retweet_count = tweet.retweet_count )
				dbobject01.put("retweeted",md.retweeted =  tweet.retweeted)
				dbobject01.put("source",md.source =  tweet.source)
				dbobject01.put("text", md.text =  tweet.text)
				dbobject01.put("lang",md.lang = tweet.lang)
				collection01.insert(dbobject01)
			})
		}
	}
}
