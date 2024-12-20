import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        
        Random rand = new Random();
        
        HashMap<String, String[]> map = makeHashMap();
        String[] genreList = {"action", "drama", "comedy", "horror", "romance", "sci-fi", "adventure"};
        String[] ratingList = {"G", "PG", "PG-13", "R"};
          
        System.out.println("Hi, welcome to Smiling Movie Recommendation Bot :)! I'm here to recommend you a movie. I hope you find a movie you like today :)");

        Scanner exitPrompt = new Scanner(System.in);

        String exit = "";

        while (exit.contains("xit") == false){
            exit = "ore";

            int genre = genreAsk(genreList);       
            System.out.println("Okay then! You chose " + genreList[genre-1] + " :)\n");

            int rating = ratingAsk(ratingList);
            System.out.println("Alright, the rating will be " + ratingList[rating-1] + " :)\n");

            String genreCode = Integer.toString(genre) + Integer.toString(rating);
            String[] recommendations = map.get(genreCode);
  

            while (exit.contains("ore")){
                System.out.println("I have a great movie for you :) I recommend " + recommendations[rand.nextInt(recommendations.length-1)] + "\n");
                System.out.println("Do you want another movie of that same type? If you didn't like that recommendation, say \"more\" to see another one :) If you want to stop, say \"exit\" now. Otherwise, you'll restart the process and pick a new genre and rating :)");
                exit = exitPrompt.nextLine();
                System.out.println("Ok, understood :)");
            }
        }

        System.out.println("Thank you for using Movie Bot! Please enjoy your movie :)");
    }

    public static int genreAsk(String[] genreList) {
        Random rand = new Random();

        Scanner genrePrompt = new Scanner(System.in);

        String[] stringErrorList = {"Input just an integer, not a string, please :)", "I said to input an integer; that means a number. I'm sure you can do it :)", "Looks like you're a little slow :) How hard could it be to input an integer? Try again, or else, okay?", "You know what? I'm done :) You don't get to choose anymore, okay? :)"};
        String[] rangeErrorList = {"Please make sure you input an integer from 1 - 7 :)", "That's not a number from 1 - 7... Try your best, I believe in you :)", "Oh no. It seems you're a little numerically challenged :) One   to   seven. Let's hope you can get it this time, or else!", "Wow. It looks like some people don't deserve choices. That means you, okay? :)"};
        int stringErrorCount = 0;
        int rangeErrorCount = 0;

        int genre = -1;

        while (genre < 1 || genre > 7){
            System.out.println("Now, pick a genre :) Input:");

            for (int i = 0; i < genreList.length; i++){
                System.out.println(i + 1 + " for "+ genreList[i]);
            }
           
            try {
                genre = genrePrompt.nextInt();   
                if (genre >= 1 && genre <= 7){
                    System.out.println("Wow, good choice :)");
                } else {
                    System.out.println(rangeErrorList[rangeErrorCount]);
                    rangeErrorCount++;
                }
            } catch (Exception ex) {
                System.out.println(stringErrorList[stringErrorCount]); 
                stringErrorCount++;
                genrePrompt.nextLine();
            }
            if (stringErrorCount == 4 || rangeErrorCount == 4){
                genre = rand.nextInt(6) + 1;
            }
        }
        return genre;
    }

    
    public static int ratingAsk(String[] ratingList) {
        Random rand = new Random();

        Scanner ratingPrompt = new Scanner(System.in);

        String[] stringErrorList = {"No strings, please :) Just an integer.", "You're supposed to input a number :) A number, okay? No letters, you got this :)", "You never fail to disappoint! :) I know it's very very hard for you, but just input a number :)", "I can't take this anymore :) Let's just move on :)"};
        String[] rangeErrorList = {"Please pick from numbers 1 - 4 :)", "Aww, so close... Input an integer from 1 - 4, you can do it :)", "Are you dumb? :) Input a number from one through four. You may not get to choose, otherwise :)", "Why am I not surprised? Looks like you're not capable of makinh your own choices :)"};
        int stringErrorCount = 0;
        int rangeErrorCount = 0;

        int rating = -1;

        while (rating < 1 || rating > 4){
            System.out.println("Pick a rating now :) Input:");

            for (int i = 0; i < ratingList.length; i++){
                System.out.println(i + 1 + " for "+ ratingList[i]);
            }
           
            try {
                rating = ratingPrompt.nextInt();   
                if (rating >= 1 && rating <= 4){
                    System.out.println("Okay, got it :)");
                } else {
                    System.out.println(rangeErrorList[rangeErrorCount]);
                    rangeErrorCount++;
                }
            } catch (Exception ex) {
                System.out.println(stringErrorList[stringErrorCount]); 
                stringErrorCount++;
                ratingPrompt.nextLine();
            }
            if (stringErrorCount == 4 || rangeErrorCount == 4){
                rating = rand.nextInt(3) + 1;
            }
        }
        return rating;
    }

    public static HashMap<String, String[]> makeHashMap(){

        HashMap<String, String[]> map = new HashMap<>();

        // Action
    map.put("11", new String[]{
        "The Incredibles (2004). A family of superheroes tries to live a quiet life while battling a supervillain.",
        "Spy Kids (2001). Two kids become secret agents to save their kidnapped parents.",
        "Big Hero 6 (2014). A robotics prodigy forms a superhero team to combat a masked villain.",
        "PAW Patrol: The Movie (2021). The heroic pups face a new challenge when a rival becomes mayor and wreaks havoc.",
        "The Iron Giant (1999). A young boy befriends a giant robot while trying to protect it from the government."
        });

    map.put("12", new String[]{
        "The Dark Knight (2008). Batman faces off against his greatest nemesis, the Joker, who seeks to plunge Gotham into chaos.",
        "Iron Man (2008). After being held captive, Tony Stark builds a high-tech suit to fight evil.",
        "Spider-Man: Homecoming (2017). Peter Parker balances his high school life with his superhero duties.",
        "Black Panther (2018). T'Challa returns to Wakanda to take the throne, only to face a powerful enemy.",
        "The Hunger Games (2012). A young girl is forced to participate in a deadly televised competition."
        });

     map.put("13", new String[]{
        "The Dark Knight (2008). Batman faces off against his greatest nemesis, the Joker, who seeks to plunge Gotham into chaos.",
        "Iron Man (2008). After being held captive, Tony Stark builds a high-tech suit to fight evil.",
        "Spider-Man: Homecoming (2017). Peter Parker balances his high school life with his superhero duties.",
        "Black Panther (2018). T'Challa returns to Wakanda to take the throne, only to face a powerful enemy.",
        "The Hunger Games (2012). A young girl is forced to participate in a deadly televised competition."
        });

    map.put("14", new String[]{
        "John Wick (2014). A retired hitman seeks vengeance after his dog is killed.",
        "Mad Max: Fury Road (2015). In a post-apocalyptic world, a drifter helps a group of women escape a tyrant.",
        "Die Hard (1988). A New York cop fights terrorists who have taken hostages in a Los Angeles skyscraper.",
        "The Matrix (1999). A hacker discovers the reality he lives in is a simulation and joins a rebellion.",
        "Gladiator (2000). A Roman general-turned-slave seeks revenge against the emperor who murdered his family."
        });

    // Drama
    map.put("21", new String[]{
        "Charlotte's Web (1973). A pig named Wilbur befriends a spider who tries to save him from being slaughtered.",
        "The Sound of Music (1965). A young woman becomes a governess to a large family in Austria and teaches them to sing.",
        "Inside Out (2015). A young girl's emotions personified as characters guide her through a difficult life transition.",
        "Bambi (1942). A young deer grows up learning the dangers of life in the forest.",
        "The Red Balloon (1956). A young boy in Paris befriends a red balloon with a mind of its own."
        });

    map.put("22", new String[]{
        "Forrest Gump (1994). A slow-witted man unintentionally influences major historical events while waiting for his love.",
        "The Pursuit of Happyness (2006). A struggling salesman works tirelessly to provide for his son while chasing his dreams.",
        "Dead Poets Society (1989). An English teacher inspires his students to embrace poetry and seize the day.",
        "The Blind Side (2009). A wealthy family takes in a homeless teenager, helping him become a football star.",
        "A Beautiful Mind (2001). A mathematician battles schizophrenia while making groundbreaking discoveries."
        });

    map.put("23", new String[]{
        "The Social Network (2010). The story of the founding of Facebook and the ensuing legal battles.",
        "Good Will Hunting (1997). A janitor at MIT solves complex math problems but struggles to accept his own brilliance.",
        "The King's Speech (2010). The story of King George VI’s efforts to overcome his stammer with the help of a speech therapist.",
        "A Star is Born (2018). A fading musician helps a young singer find fame, even as his own career spirals downward.",
        "The Imitation Game (2014). A mathematician and his team race against time to crack Nazi codes during World War II."
        });

    map.put("24", new String[]{
        "Requiem for a Dream (2000). Four individuals spiral into drug addiction with devastating consequences.",
        "The Godfather (1972). A mafia family patriarch balances the criminal underworld and family loyalty.",
        "Schindler's List (1993). A businessman saves Jewish refugees from the Holocaust by employing them in his factories.",
        "A Clockwork Orange (1971). A delinquent youth undergoes controversial behavior-modification therapy.",
        "Fight Club (1999). A disillusioned office worker forms an underground fight club with a soap salesman."
        });

    // Comedy
    map.put("31", new String[]{
        "The Muppet Movie (1979). Kermit the Frog embarks on a cross-country trip to Hollywood.",
        "The Many Adventures of Winnie the Pooh (1977). Winnie the Pooh and his friends have gentle, amusing adventures in the Hundred Acre Wood.",
        "The Cat in the Hat (1971). Two children have a wild day of fun when the Cat in the Hat visits them.",
        "Mary Poppins (1964). A magical nanny helps two children bond with their father.",
        "Curious George (2006). A mischievous monkey causes trouble while making friends with the Man in the Yellow Hat."
        });

    map.put("32", new String[]{
        "School of Rock (2003). A musician poses as a substitute teacher and turns his class into a rock band.",
        "Night at the Museum (2006). A night security guard discovers that the exhibits at the museum come to life after dark.",
        "Elf (2003). A man raised as an elf at the North Pole goes to New York to find his biological father.",
        "The LEGO Movie (2014). An ordinary LEGO minifigure is mistakenly thought to be the prophesied 'Special' and is recruited to save the world.",
        "Mrs. Doubtfire (1993). A man disguises himself as a female housekeeper to spend more time with his children."
        });

    map.put("33", new String[]{
        "The Princess Diaries (2001). A clumsy teenager discovers she's the heir to a European throne.",
        "Mean Girls (2004). A new student navigates the cutthroat social hierarchy of high school.",
        "Ferris Bueller's Day Off (1986). A high schooler skips school and embarks on an adventure-filled day.",
        "Jumanji: Welcome to the Jungle (2017). Four teenagers are sucked into a video game and must survive a dangerous jungle.",
        "Pitch Perfect (2012). A college student joins an a cappella group and helps them prepare for competition."
        });

    map.put("34", new String[]{
        "Superbad (2007). Two high school seniors' plans for a wild party spiral into chaotic misadventures.",
        "The Hangover (2009). Three friends wake up in Las Vegas with no memory of the previous night and a missing groom.",
        "Tropic Thunder (2008). A group of actors filming a war movie unwittingly get caught in real jungle warfare.",
        "American Pie (1999). Four high school friends make a pact to lose their virginity before graduation.",
        "Step Brothers (2008). Two middle-aged men become stepbrothers and must learn to live together as adults."
        });

    // Horror
    map.put("41", new String[]{
        "Coraline (2009). A young girl discovers a parallel world that's not as perfect as it seems.",
        "The Adventures of Ichabod and Mr. Toad (1949). A retelling of the eerie legend of Sleepy Hollow.",
        "Monster House (2006). Three kids discover their neighbor's house is actually a living, breathing monster.",
        "Casper (1995). A young girl befriends a friendly ghost in her new home.",
        "The Nightmare Before Christmas (1993). The Pumpkin King of Halloween Town seeks to bring Christmas to his spooky realm."
        });

    map.put("42", new String[]{
        "Poltergeist (1982). A family's home is haunted by a host of terrifying ghosts.",
        "The Others (2001). A mother of two light-sensitive children begins to suspect her house is haunted.",
        "The Ring (2002). A journalist investigates a mysterious videotape that causes viewers to die seven days after watching.",
        "Insidious (2010). A couple fights to save their son after he falls into a coma and becomes a vessel for spirits.",
        "The Sixth Sense (1999). A young boy who sees dead people forms an unlikely bond with his psychologist."
        });

    map.put("43", new String[]{
        "A Quiet Place (2018). A family must live in silence to avoid creatures that hunt by sound.",
        "The Conjuring (2013). Paranormal investigators help a family terrorized by a dark presence in their farmhouse.",
        "The Exorcism of Emily Rose (2005). A lawyer takes on a case involving a priest accused of negligent homicide after performing an exorcism.",
        "Mama (2013). Two sisters are haunted by a dark presence after being rescued from the wilderness.",
        "The Woman in Black (2012). A young lawyer is sent to a remote village, where he discovers the vengeful ghost of a scorned woman."
        });

    map.put("44", new String[]{
        "Hereditary (2018). A family uncovers terrifying secrets about their ancestry after the death of the grandmother.",
        "The Exorcist (1973). A mother seeks help from priests to exorcise her demon-possessed daughter.",
        "A Nightmare on Elm Street (1984). Teenagers are haunted by a killer who invades their dreams.",
        "The Texas Chainsaw Massacre (1974). A group of friends encounters a family of cannibals while visiting rural Texas.",
        "It (2017). A group of children confront an ancient, shape-shifting evil that takes the form of a clown."
        });

    // Romance
    map.put("51", new String[]{
        "Beauty and the Beast (1991). A young woman falls in love with a prince cursed to live as a beast.",
        "The Little Mermaid (1989). A mermaid princess makes a dangerous deal to live as a human and be with the prince she loves.",
        "Cinderella (1950). A young woman dreams of attending the royal ball and falls in love with the prince.",
        "Enchanted (2007). A fairytale princess is transported to modern-day New York City, where she falls in love with a divorce lawyer.",
        "Tangled (2010). Rapunzel, a long-lost princess with magical hair, sets off on an adventure to find herself and love."
        });

    map.put("52", new String[]{
        "The Princess Bride (1987). A young woman is kidnapped and rescued by her true love in a fantasy kingdom.",
        "13 Going on 30 (2004). A teenager wakes up as a 30-year-old woman and learns valuable lessons about love and life.",
        "Notting Hill (1999). A bookstore owner falls in love with a famous actress who wanders into his shop.",
        "Sleepless in Seattle (1993). A widower and a journalist fall in love after a radio call-in show.",
        "Crazy Rich Asians (2018). A New Yorker discovers her boyfriend's family is one of the richest in Singapore."
        });

    map.put("53", new String[]{
        "The Fault in Our Stars (2014). Two teens with cancer fall in love and grapple with life’s uncertainties.",
        "Pride and Prejudice (2005). Elizabeth Bennet and Mr. Darcy must overcome their pride and misunderstandings to find love.",
        "Twilight (2008). A teenage girl falls in love with a vampire, triggering a dangerous love triangle.",
        "A Walk to Remember (2002). A rebellious high schooler falls for a quiet girl with a tragic secret.",
        "La La Land (2016). An aspiring actress and a jazz musician fall in love while chasing their dreams in Los Angeles."
        });

    map.put("54", new String[]{
        "Blue Valentine (2010). A married couple’s relationship unravels as they reflect on their past.",
        "Call Me by Your Name (2017). A teenage boy and a visiting scholar begin a passionate summer romance in Italy.",
        "The Notebook (2004). A poor young man and a wealthy young woman fall in love despite societal pressures.",
        "500 Days of Summer (2009). A man reflects on his failed relationship with a woman who didn’t believe in love.",
        "Brokeback Mountain (2005). Two cowboys develop a complex romantic and sexual relationship in the American West."
        });

    // Sci-Fi
    map.put("61", new String[]{
        "WALL-E (2008). A waste-collecting robot embarks on a space journey that will determine the future of mankind.",
        "E.T. the Extra-Terrestrial (1982). A young boy befriends a gentle alien stranded on Earth.",
        "The Iron Giant (1999). A boy befriends a giant robot and tries to protect it from government forces.",
        "Zathura (2005). Two brothers play a board game that takes them into outer space on a dangerous adventure.",
        "Meet the Robinsons (2007). A boy travels to the future and meets a quirky family who might hold the key to his destiny."
        });

    map.put("62", new String[]{
        "Star Wars: A New Hope (1977). A young farm boy joins a rebellion to stop a tyrannical empire.",
        "The Fifth Element (1997). A cab driver becomes involved in a quest to find four stones that will prevent an apocalyptic evil from destroying Earth.",
        "Men in Black (1997). Two agents work to protect Earth from alien threats while keeping extraterrestrial activity secret.",
        "Back to the Future (1985). A teenager is accidentally sent 30 years into the past in a time-traveling DeLorean.",
        "Ready Player One (2018). A young man joins a contest in a virtual reality world to win control of the OASIS."
        });

    map.put("63", new String[]{
        "Inception (2010). A thief who steals corporate secrets through dream-sharing technology is given a chance to erase his criminal record.",
        "The Matrix (1999). A hacker discovers that reality is a simulated world controlled by machines.",
        "Jurassic World (2015). A theme park with genetically-engineered dinosaurs spirals into chaos when one escapes.",
        "Interstellar (2014). A team of explorers travels through a wormhole to find a new home for humanity.",
        "The Hunger Games (2012). A girl participates in a televised fight to the death in a dystopian future."
        });

    map.put("64", new String[]{
        "Blade Runner 2049 (2017). A young blade runner discovers a long-buried secret that leads him to a former blade runner, Deckard.",
        "Alien (1979). A space crew encounters a deadly alien creature on their ship.",
        "The Terminator (1984). A cyborg assassin is sent back in time to kill a woman whose son will save humanity.",
        "District 9 (2009). A bureaucrat becomes an unlikely hero after being exposed to alien technology.",
        "The Fly (1986). A scientist’s experiment with teleportation goes horribly wrong when he is fused with a fly."
        });

    // Adventure
    map.put("71", new String[]{
        "The Lion King (1994). A young lion prince flees his kingdom after the murder of his father, only to return years later to reclaim it.",
        "Finding Nemo (2003). A clownfish goes on an adventure across the ocean to rescue his captured son.",
        "The Jungle Book (1967). A boy raised by wolves embarks on a journey to return to human society.",
        "Moana (2016). A young woman sets sail across the ocean to restore her island’s prosperity.",
        "Up (2009). An elderly man and a young boy set off on an adventure in a house lifted by balloons."
        });

    map.put("72", new String[]{
        "Harry Potter and the Sorcerer's Stone (2001). A young boy discovers he is a wizard and begins his education at Hogwarts School of Witchcraft and Wizardry.",
        "Pirates of the Caribbean: The Curse of the Black Pearl (2003). A blacksmith and a pirate team up to rescue a kidnapped woman and lift an ancient curse.",
        "Jumanji (1995). A board game unleashes jungle dangers upon two children and the man trapped inside the game.",
        "The Chronicles of Narnia: The Lion, the Witch and the Wardrobe (2005). Four siblings enter a magical world and help its rightful ruler reclaim the throne.",
        "Indiana Jones and the Last Crusade (1989). An archaeologist teams up with his father to find the Holy Grail before the Nazis."
        });

    map.put("73", new String[]{
        "The Lord of the Rings: The Fellowship of the Ring (2001). A young hobbit joins a fellowship on a quest to destroy a powerful ring.",
        "Avatar (2009). A paraplegic Marine is sent to a distant moon where he joins its inhabitants in a fight for survival.",
        "Guardians of the Galaxy (2014). A group of misfits band together to stop a powerful enemy from destroying the galaxy.",
        "The Hobbit: An Unexpected Journey (2012). A reluctant hobbit embarks on a quest to reclaim a lost kingdom from a fearsome dragon.",
        "The Mummy (1999). Adventurers accidentally awaken an ancient Egyptian priest who begins a campaign of terror."
        });

    map.put("74", new String[]{
        "Mad Max: Fury Road (2015). In a post-apocalyptic wasteland, a drifter helps a group of women escape a tyrannical warlord.",
        "The Revenant (2015). A frontiersman sets out on a grueling journey of survival and revenge after being left for dead.",
        "Apocalypto (2006). A tribesman must escape human sacrifice and rescue his family in a brutal ancient civilization.",
        "Gladiator (2000). A betrayed Roman general fights for revenge in the gladiatorial arena.",
        "No Country for Old Men (2007). A hunter stumbles upon a drug deal gone wrong, triggering a violent chain of events."
        });

        return map;

    }

}