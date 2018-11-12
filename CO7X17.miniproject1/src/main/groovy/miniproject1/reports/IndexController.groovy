package miniproject1.reports;

import com.mongodb.DBCollection
import java.util.List
import miniproject1.mongoDb.MongoDB
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	def mongo = new MongoDB()

	@RequestMapping
	public String index(Model model) {
		def connectionStatus = 'PENDING'
		if (mongo.connectionOk()) {
			connectionStatus = 'CONNECTED'
		}

		model.addAttribute('connectionStatus', connectionStatus)
		return "main"
	}


	@RequestMapping(value="followers", method=RequestMethod.GET)
	public String followers(Model model) {
		def followedFollowers = []

		// tag::exercise[]

		// Exercise 2

		//end::exercise[]

		model.addAttribute("followers", followedFollowers);
		return "followers";
	}


	@RequestMapping(value="friends",method=RequestMethod.GET)
	public String friends(Model model) {

		List<FriendDto> friends = new ArrayList<FriendDto>()


/*		
 * *********This is the code for question 3rd , My approach is to fetch data from local json file given reffering to the lab3  *****
 *   
 * def slurper = new groovy.json.JsonSlurper()//creating slurper object
		def tweetdata = slurper.parseText(new File("./src/main/resources/twitter/tweets.json").text)
		def friendsTable = slurper.parseText(new File("./src/main/resources/twitter/friends.json").text)//values in friendsTable
		def tweetofuser

		FriendDto frienddto = new FriendDto() // creating object of FriendDto class
		friendsTable.users.each{ friend ->
			// iterating over json flle friends object

			frienddto.noMaxRetweets = 0
			def flag = 0
			def id
			def maxretweets = 0


			frienddto.name=friend.name //putting data into friends object
			frienddto.description=friend.description // adding description into friends object

			tweetofuser = tweetdata.findAll({ tweet ->
				(tweet.user != null) && (tweet.user.id == friend.id) //condition to restricts data of only friends

				for (tw in tweetofuser) { //  iterate over tweetuserr

					if(tw.noMaxRetweets < tw.retweet_count + tw.favorite_count) { // logic to find noMaxtweets

						frienddto.noMaxRetweets = frienddto.retweet_count + frienddto.favorite_count

						frienddto.popularTweets = tweetofuser.text // text of the user/

					}
				}

			})*/



//			friends.add(friendto)

		}



//		model.addAttribute("friends", friends);
//		return "friends";
//	}

}
