package com.xlrantlabs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSummariser
{
    @Test
    public void testSummariser_orkoWikipedia()
    {
        String text = "Orko is a fictional character from the Masters of the Universe franchise.[1] He was not part of "
                + "the original toy collection on which the show is based, but when he was created by the show's " +
                "writers as comic relief, a toy figure of him was then manufactured. Orko appears in the 1980s " +
                "Filmation series He-Man and the Masters of the Universe and in the 2002 remake of the series. " +
                "The character was named Gorpo in the early original series drafts, but he was renamed Orko (his " +
                "original name was used in the Brazilian Portuguese-language dub of the original series)." +
                "\n\n" +
                "Orko is a Trollan, a race of beings from Trolla, a world in another dimension. Trollans wear red " +
                "robes, red hats, and hide their faces beneath hats and behind scarves. In Trollan society, showing " +
                "one's face to each other is considered an intimate act, similar to humans sharing a kiss. A " +
                "production drawing of Orko without his hat showed him resembling little blue elf, but it was never " +
                "used in the series. Orko does reveal his face in the episode \"Dawn of Dragoon\", but his face is " +
                "not visible to the audience, though his shadow indicates he is bald. Trollans appear to be " +
                "blue-skinned humanoids with pointy ears. However, their feet remain hidden under their robes. " +
                "Trollans have natural magical abilities, including levitation, which they use exclusively instead " +
                "of walking. In one episode, Orko temporarily loses the power of levitation, and can be seen " +
                "crawling around on his knees. Still, some Trollans have greater magical power than others; Orko's " +
                "uncle, for example, is a noted magician. Orko knows He-Man's true identity." +
                "\n\n" +
                "Orko has always had trouble with his magical powers. A recurring joke in the series is that almost " +
                "every time he tries to use magic, it backfires in some amusing way. The reason for this is not " +
                "clear; in one episode, it is suggested that Trolla operates with natural laws that are the opposite " +
                "of Eternia's, and that in Trolla, Orko was a good magician. However, in later episodes this is " +
                "contradicted, and Orko is shown to be equally incompetent even on Trolla. Another episode indicates " +
                " that Orko possessed a magical pendant that allowed him to use magic correctly, but that he later " +
                "lost it. The amulet later turned up stuck on the back of a dinosaur resurrected by Skeletor. When " +
                "Orko got back the amulet to erase the happening events, it goes back on the dinosaur before it all " +"" +
                "happens." +
                "\n\n" +
                "In addition to his magic spells, Orko also stores an impossibly large plethora of items, some " +
                "useful, some not so useful, inside his hat." +
                "\n\n" +
                "Orko came to Eternia when a cosmic storm accidentally transported him there. He appeared in the Tar " +
                "Swamp, where he found a young Prince Adam and his pet, Cringer, at the time a tiger cub, and saved " +
                "them both from dying in the tar. However, he lost his pendant in the process after colliding " +
                "with a tree." +
                "\n\n" +
                "Stuck on Eternia, Orko was made Royal Buffoon by the King of Eternia in gratitude for having saved " +
                "his son. Orko became one of Adam's closest friends; in fact, Orko knows that Adam is secretly " +
                "He-Man, it is revealed in season one episode one of the masters of the universe that Orko followed " +
                "Prince Adam to Castle Greyskull, thus knowing He-Man and Prince Adam's true identity. Orko " +
                "frequently annoys Man-At-Arms, due to his magic constantly backfiring or Orko coming into his lab " +
                "unexpected and uninvited and messing with his equipment, which gets on Man-At-Arms' nerves, rather " +
                "than amusing him as it does others. Orko has proven to be a good friend and a valuable ally, " +
                "despite his unpredictable powers and the fact he is more than a little clueless. Sometimes, Orko " +
                "wonders how useful he is to He-Man, but despite his apparent cowardliness, he never fails to help " +
                "those in need. Also, throughout the series, Adam/He-Man is constantly in Orko's debt for saving his " +
                "life when he was a child. On two occasions, He-Man has helped Orko regain his magical powers." +
                "\n\n" +
                "Orko returns to Trolla, with the help of others, on a number of occasions. The first time, he helps " +
                "He-Man save the life of several Trollans captured by one of Skeletor's allies, a humanoid dragon " +
                "named Dragoon, and begins a romance with a Trollan girl named Dree Elle. However, he decides that " +
                "his place is now on Eternia, and so he returns there. However, he still occasionally visits his " +
                "friends and relatives on Trolla." +
                "\n\n" +
                "In the 2002 series, Orko is essentially the same with a slightly more elaborate costume. It is " +
                "revealed that he and Cringer followed Prince Adam to Castle Grayskull and watched him transform " +
                "into He-Man for the first time. Orko then follows He-Man and the new Battle Cat into battle and " +
                "almost reveals He-Man's identity to Teela and the other Masters, despite having been warned by " +
                "both The Sorceress and He-Man not to. Fortunately, Man-At-Arms, who recognizes He-Man as the alter " +
                "ego of Adam, quickly steps in and stops him, informing Teela and the other Masters that the new " +
                "hero is He-Man and that the Sorceress had told him of He-Man's coming beforehand. In this series, " +
                "Orko was a very powerful wizard, but when he came to Eternia and saved Prince Adam, he lost his " +
                "wand, which was needed to control his magic. Since his arrival, Orko is the jester of the royal " +
                "palace, and although he is well liked, few take him seriously. Orko is always keen to become the " +
                "great sorcerer he once was, without his wand to control his magic, he is prone to causing havoc " +
                "around the palace. However, there have been instances where Orko has played a huge role in battles. " +
                "In the episode \"Lesson\", he managed to successfully disarm Skeletor of the Ram Stone. In the " +
                "episode \"Last Stand\", Orko managed to evade capture by Skeletor's council of evil and returned " +
                "Prince Adam's power sword to him. A flashback episode, \"The Power of Grayskull\", which reveals " +
                "the history of Adam's ancestor King Grayskull, who goes on a quest for the power to defend Eternia, " +
                "where Grayskull encounters an Oracle who looked and sounded much like Orko, suggesting that other " +
                "Trollans might have found their way to Eternia.";

        Summariser summariser = new Summariser();
        summariser.summarise(text, 5);

        assertEquals(8, summariser.getNumParagraphs());
        assertEquals(48, summariser.getNumSentences());

        String expectedSummary = "Orko became one of Adam's closest friends; in fact, Orko knows that Adam is " +
                "secretly He-Man, it is revealed in season one episode one of the masters of the universe that Orko " +
                "followed Prince Adam to Castle Greyskull, thus knowing He-Man and Prince Adam's true identity. Orko " +
                "frequently annoys Man-At-Arms, due to his magic constantly backfiring or Orko coming into his lab " +
                "unexpected and uninvited and messing with his equipment, which gets on Man-At-Arms' nerves, " +
                "rather than amusing him as it does others. Orko then follows He-Man and the new Battle Cat into " +
                "battle and almost reveals He-Man's identity to Teela and the other Masters, despite having been " +
                "warned by both The Sorceress and He-Man not to. Fortunately, Man-At-Arms, who recognizes He-Man as " +
                "the alter ego of Adam, quickly steps in and stops him, informing Teela and the other Masters that " +
                "the new hero is He-Man and that the Sorceress had told him of He-Man's coming beforehand. In this " +
                "series, Orko was a very powerful wizard, but when he came to Eternia and saved Prince Adam, he lost " +
                "his wand, which was needed to control his magic.";
        assertEquals(expectedSummary, summariser.getSummary());
    }

    @Test
    public void testSummariser_anneOfGreenGablesChapterOne()
    {
        String text = "MRS. Rachel Lynde lived just where the Avonlea main road dipped down\n" +
                "into a little hollow, fringed with alders and ladies' eardrops and\n" +
                "traversed by a brook that had its source away back in the woods of the\n" +
                "old Cuthbert place; it was reputed to be an intricate, headlong brook\n" +
                "in its earlier course through those woods, with dark secrets of pool\n" +
                "and cascade; but by the time it reached Lynde's Hollow it was a quiet,\n" +
                "well-conducted little stream, for not even a brook could run past Mrs.\n" +
                "Rachel Lynde's door without due regard for decency and decorum; it\n" +
                "probably was conscious that Mrs. Rachel was sitting at her window,\n" +
                "keeping a sharp eye on everything that passed, from brooks and children\n" +
                "up, and that if she noticed anything odd or out of place she would never\n" +
                "rest until she had ferreted out the whys and wherefores thereof.\n" +
                "\n" +
                "There are plenty of people in Avonlea and out of it, who can attend\n" +
                "closely to their neighbor's business by dint of neglecting their own;\n" +
                "but Mrs. Rachel Lynde was one of those capable creatures who can manage\n" +
                "their own concerns and those of other folks into the bargain. She was a\n" +
                "notable housewife; her work was always done and well done; she “ran” the\n" +
                "Sewing Circle, helped run the Sunday-school, and was the strongest prop\n" +
                "of the Church Aid Society and Foreign Missions Auxiliary. Yet with all\n" +
                "this Mrs. Rachel found abundant time to sit for hours at her kitchen\n" +
                "window, knitting “cotton warp” quilts--she had knitted sixteen of them,\n" +
                "as Avonlea housekeepers were wont to tell in awed voices--and keeping\n" +
                "a sharp eye on the main road that crossed the hollow and wound up\n" +
                "the steep red hill beyond. Since Avonlea occupied a little triangular\n" +
                "peninsula jutting out into the Gulf of St. Lawrence with water on two\n" +
                "sides of it, anybody who went out of it or into it had to pass over that\n" +
                "hill road and so run the unseen gauntlet of Mrs. Rachel's all-seeing\n" +
                "eye.\n" +
                "\n" +
                "She was sitting there one afternoon in early June. The sun was coming in\n" +
                "at the window warm and bright; the orchard on the slope below the house\n" +
                "was in a bridal flush of pinky-white bloom, hummed over by a myriad of\n" +
                "bees. Thomas Lynde--a meek little man whom Avonlea people called “Rachel\n" +
                "Lynde's husband”--was sowing his late turnip seed on the hill field\n" +
                "beyond the barn; and Matthew Cuthbert ought to have been sowing his on\n" +
                "the big red brook field away over by Green Gables. Mrs. Rachel knew\n" +
                "that he ought because she had heard him tell Peter Morrison the evening\n" +
                "before in William J. Blair's store over at Carmody that he meant to sow\n" +
                "his turnip seed the next afternoon. Peter had asked him, of course, for\n" +
                "Matthew Cuthbert had never been known to volunteer information about\n" +
                "anything in his whole life.\n" +
                "\n" +
                "And yet here was Matthew Cuthbert, at half-past three on the afternoon\n" +
                "of a busy day, placidly driving over the hollow and up the hill;\n" +
                "moreover, he wore a white collar and his best suit of clothes, which was\n" +
                "plain proof that he was going out of Avonlea; and he had the buggy\n" +
                "and the sorrel mare, which betokened that he was going a considerable\n" +
                "distance. Now, where was Matthew Cuthbert going and why was he going\n" +
                "there?\n" +
                "\n" +
                "Had it been any other man in Avonlea, Mrs. Rachel, deftly putting this\n" +
                "and that together, might have given a pretty good guess as to both\n" +
                "questions. But Matthew so rarely went from home that it must be\n" +
                "something pressing and unusual which was taking him; he was the shyest\n" +
                "man alive and hated to have to go among strangers or to any place where\n" +
                "he might have to talk. Matthew, dressed up with a white collar and\n" +
                "driving in a buggy, was something that didn't happen often. Mrs. Rachel,\n" +
                "ponder as she might, could make nothing of it and her afternoon's\n" +
                "enjoyment was spoiled.\n" +
                "\n" +
                "“I'll just step over to Green Gables after tea and find out from Marilla\n" +
                "where he's gone and why,” the worthy woman finally concluded. “He\n" +
                "doesn't generally go to town this time of year and he _never_ visits; if\n" +
                "he'd run out of turnip seed he wouldn't dress up and take the buggy to\n" +
                "go for more; he wasn't driving fast enough to be going for a doctor.\n" +
                "Yet something must have happened since last night to start him off. I'm\n" +
                "clean puzzled, that's what, and I won't know a minute's peace of mind or\n" +
                "conscience until I know what has taken Matthew Cuthbert out of Avonlea\n" +
                "today.”\n" +
                "\n" +
                "Accordingly after tea Mrs. Rachel set out; she had not far to go; the\n" +
                "big, rambling, orchard-embowered house where the Cuthberts lived was a\n" +
                "scant quarter of a mile up the road from Lynde's Hollow. To be sure, the\n" +
                "long lane made it a good deal further. Matthew Cuthbert's father, as\n" +
                "shy and silent as his son after him, had got as far away as he possibly\n" +
                "could from his fellow men without actually retreating into the woods\n" +
                "when he founded his homestead. Green Gables was built at the furthest\n" +
                "edge of his cleared land and there it was to this day, barely visible\n" +
                "from the main road along which all the other Avonlea houses were so\n" +
                "sociably situated. Mrs. Rachel Lynde did not call living in such a place\n" +
                "_living_ at all.\n" +
                "\n" +
                "“It's just _staying_, that's what,” she said as she stepped along the\n" +
                "deep-rutted, grassy lane bordered with wild rose bushes. “It's no wonder\n" +
                "Matthew and Marilla are both a little odd, living away back here by\n" +
                "themselves. Trees aren't much company, though dear knows if they were\n" +
                "there'd be enough of them. I'd ruther look at people. To be sure, they\n" +
                "seem contented enough; but then, I suppose, they're used to it. A body\n" +
                "can get used to anything, even to being hanged, as the Irishman said.”\n" +
                "\n" +
                "With this Mrs. Rachel stepped out of the lane into the backyard of Green\n" +
                "Gables. Very green and neat and precise was that yard, set about on one\n" +
                "side with great patriarchal willows and the other with prim Lombardies.\n" +
                "Not a stray stick nor stone was to be seen, for Mrs. Rachel would have\n" +
                "seen it if there had been. Privately she was of the opinion that Marilla\n" +
                "Cuthbert swept that yard over as often as she swept her house. One could\n" +
                "have eaten a meal off the ground without over-brimming the proverbial\n" +
                "peck of dirt.\n" +
                "\n" +
                "Mrs. Rachel rapped smartly at the kitchen door and stepped in\n" +
                "when bidden to do so. The kitchen at Green Gables was a cheerful\n" +
                "apartment--or would have been cheerful if it had not been so painfully\n" +
                "clean as to give it something of the appearance of an unused parlor. Its\n" +
                "windows looked east and west; through the west one, looking out on\n" +
                "the back yard, came a flood of mellow June sunlight; but the east one,\n" +
                "whence you got a glimpse of the bloom white cherry-trees in the left\n" +
                "orchard and nodding, slender birches down in the hollow by the brook,\n" +
                "was greened over by a tangle of vines. Here sat Marilla Cuthbert, when\n" +
                "she sat at all, always slightly distrustful of sunshine, which seemed to\n" +
                "her too dancing and irresponsible a thing for a world which was meant to\n" +
                "be taken seriously; and here she sat now, knitting, and the table behind\n" +
                "her was laid for supper.\n" +
                "\n" +
                "Mrs. Rachel, before she had fairly closed the door, had taken a mental\n" +
                "note of everything that was on that table. There were three plates laid,\n" +
                "so that Marilla must be expecting some one home with Matthew to tea; but\n" +
                "the dishes were everyday dishes and there was only crab-apple preserves\n" +
                "and one kind of cake, so that the expected company could not be any\n" +
                "particular company. Yet what of Matthew's white collar and the sorrel\n" +
                "mare? Mrs. Rachel was getting fairly dizzy with this unusual mystery\n" +
                "about quiet, unmysterious Green Gables.\n" +
                "\n" +
                "“Good evening, Rachel,” Marilla said briskly. “This is a real fine\n" +
                "evening, isn't it? Won't you sit down? How are all your folks?”\n" +
                "\n" +
                "Something that for lack of any other name might be called friendship\n" +
                "existed and always had existed between Marilla Cuthbert and Mrs. Rachel,\n" +
                "in spite of--or perhaps because of--their dissimilarity.\n" +
                "\n" +
                "Marilla was a tall, thin woman, with angles and without curves; her dark\n" +
                "hair showed some gray streaks and was always twisted up in a hard little\n" +
                "knot behind with two wire hairpins stuck aggressively through it. She\n" +
                "looked like a woman of narrow experience and rigid conscience, which she\n" +
                "was; but there was a saving something about her mouth which, if it had\n" +
                "been ever so slightly developed, might have been considered indicative\n" +
                "of a sense of humor.\n" +
                "\n" +
                "“We're all pretty well,” said Mrs. Rachel. “I was kind of afraid _you_\n" +
                "weren't, though, when I saw Matthew starting off today. I thought maybe\n" +
                "he was going to the doctor's.”\n" +
                "\n" +
                "Marilla's lips twitched understandingly. She had expected Mrs.\n" +
                "Rachel up; she had known that the sight of Matthew jaunting off so\n" +
                "unaccountably would be too much for her neighbor's curiosity.\n" +
                "\n" +
                "“Oh, no, I'm quite well although I had a bad headache yesterday,” she\n" +
                "said. “Matthew went to Bright River. We're getting a little boy from an\n" +
                "orphan asylum in Nova Scotia and he's coming on the train tonight.”\n" +
                "\n" +
                "If Marilla had said that Matthew had gone to Bright River to meet a\n" +
                "kangaroo from Australia Mrs. Rachel could not have been more astonished.\n" +
                "She was actually stricken dumb for five seconds. It was unsupposable\n" +
                "that Marilla was making fun of her, but Mrs. Rachel was almost forced to\n" +
                "suppose it.\n" +
                "\n" +
                "“Are you in earnest, Marilla?” she demanded when voice returned to her.\n" +
                "\n" +
                "“Yes, of course,” said Marilla, as if getting boys from orphan asylums\n" +
                "in Nova Scotia were part of the usual spring work on any well-regulated\n" +
                "Avonlea farm instead of being an unheard of innovation.\n" +
                "\n" +
                "Mrs. Rachel felt that she had received a severe mental jolt. She thought\n" +
                "in exclamation points. A boy! Marilla and Matthew Cuthbert of all people\n" +
                "adopting a boy! From an orphan asylum! Well, the world was certainly\n" +
                "turning upside down! She would be surprised at nothing after this!\n" +
                "Nothing!\n" +
                "\n" +
                "“What on earth put such a notion into your head?” she demanded\n" +
                "disapprovingly.\n" +
                "\n" +
                "This had been done without her advice being asked, and must perforce be\n" +
                "disapproved.\n" +
                "\n" +
                "“Well, we've been thinking about it for some time--all winter in fact,”\n" +
                " returned Marilla. “Mrs. Alexander Spencer was up here one day before\n" +
                "Christmas and she said she was going to get a little girl from the\n" +
                "asylum over in Hopeton in the spring. Her cousin lives there and Mrs.\n" +
                "Spencer has visited here and knows all about it. So Matthew and I have\n" +
                "talked it over off and on ever since. We thought we'd get a boy. Matthew\n" +
                "is getting up in years, you know--he's sixty--and he isn't so spry as he\n" +
                "once was. His heart troubles him a good deal. And you know how desperate\n" +
                "hard it's got to be to get hired help. There's never anybody to be had\n" +
                "but those stupid, half-grown little French boys; and as soon as you do\n" +
                "get one broke into your ways and taught something he's up and off to the\n" +
                "lobster canneries or the States. At first Matthew suggested getting a\n" +
                "Home boy. But I said ‘no' flat to that. ‘They may be all right--I'm not\n" +
                "saying they're not--but no London street Arabs for me,' I said. ‘Give\n" +
                "me a native born at least. There'll be a risk, no matter who we get. But\n" +
                "I'll feel easier in my mind and sleep sounder at nights if we get a born\n" +
                "Canadian.' So in the end we decided to ask Mrs. Spencer to pick us out\n" +
                "one when she went over to get her little girl. We heard last week she\n" +
                "was going, so we sent her word by Richard Spencer's folks at Carmody\n" +
                "to bring us a smart, likely boy of about ten or eleven. We decided that\n" +
                "would be the best age--old enough to be of some use in doing chores\n" +
                "right off and young enough to be trained up proper. We mean to give him\n" +
                "a good home and schooling. We had a telegram from Mrs. Alexander Spencer\n" +
                "today--the mail-man brought it from the station--saying they were coming\n" +
                "on the five-thirty train tonight. So Matthew went to Bright River to\n" +
                "meet him. Mrs. Spencer will drop him off there. Of course she goes on to\n" +
                "White Sands station herself.”\n" +
                "\n" +
                "Mrs. Rachel prided herself on always speaking her mind; she proceeded to\n" +
                "speak it now, having adjusted her mental attitude to this amazing piece\n" +
                "of news.\n" +
                "\n" +
                "“Well, Marilla, I'll just tell you plain that I think you're doing a\n" +
                "mighty foolish thing--a risky thing, that's what. You don't know what\n" +
                "you're getting. You're bringing a strange child into your house and home\n" +
                "and you don't know a single thing about him nor what his disposition is\n" +
                "like nor what sort of parents he had nor how he's likely to turn out.\n" +
                "Why, it was only last week I read in the paper how a man and his wife up\n" +
                "west of the Island took a boy out of an orphan asylum and he set fire to\n" +
                "the house at night--set it _on purpose_, Marilla--and nearly burnt them to\n" +
                "a crisp in their beds. And I know another case where an adopted boy used\n" +
                "to suck the eggs--they couldn't break him of it. If you had asked my\n" +
                "advice in the matter--which you didn't do, Marilla--I'd have said for\n" +
                "mercy's sake not to think of such a thing, that's what.”\n" +
                "\n" +
                "This Job's comforting seemed neither to offend nor to alarm Marilla. She\n" +
                "knitted steadily on.\n" +
                "\n" +
                "“I don't deny there's something in what you say, Rachel. I've had some\n" +
                "qualms myself. But Matthew was terrible set on it. I could see that, so\n" +
                "I gave in. It's so seldom Matthew sets his mind on anything that when he\n" +
                "does I always feel it's my duty to give in. And as for the risk, there's\n" +
                "risks in pretty near everything a body does in this world. There's risks\n" +
                "in people's having children of their own if it comes to that--they don't\n" +
                "always turn out well. And then Nova Scotia is right close to the Island.\n" +
                "It isn't as if we were getting him from England or the States. He can't\n" +
                "be much different from ourselves.”\n" +
                "\n" +
                "“Well, I hope it will turn out all right,” said Mrs. Rachel in a tone\n" +
                "that plainly indicated her painful doubts. “Only don't say I didn't\n" +
                "warn you if he burns Green Gables down or puts strychnine in the well--I\n" +
                "heard of a case over in New Brunswick where an orphan asylum child did\n" +
                "that and the whole family died in fearful agonies. Only, it was a girl\n" +
                "in that instance.”\n" +
                "\n" +
                "“Well, we're not getting a girl,” said Marilla, as if poisoning wells\n" +
                "were a purely feminine accomplishment and not to be dreaded in the case\n" +
                "of a boy. “I'd never dream of taking a girl to bring up. I wonder at\n" +
                "Mrs. Alexander Spencer for doing it. But there, _she_ wouldn't shrink\n" +
                "from adopting a whole orphan asylum if she took it into her head.”\n" +
                "\n" +
                "Mrs. Rachel would have liked to stay until Matthew came home with his\n" +
                "imported orphan. But reflecting that it would be a good two hours at\n" +
                "least before his arrival she concluded to go up the road to Robert\n" +
                "Bell's and tell the news. It would certainly make a sensation second\n" +
                "to none, and Mrs. Rachel dearly loved to make a sensation. So she took\n" +
                "herself away, somewhat to Marilla's relief, for the latter felt\n" +
                "her doubts and fears reviving under the influence of Mrs. Rachel's\n" +
                "pessimism.\n" +
                "\n" +
                "“Well, of all things that ever were or will be!” ejaculated Mrs. Rachel\n" +
                "when she was safely out in the lane. “It does really seem as if I must\n" +
                "be dreaming. Well, I'm sorry for that poor young one and no mistake.\n" +
                "Matthew and Marilla don't know anything about children and they'll\n" +
                "expect him to be wiser and steadier that his own grandfather, if so be's\n" +
                "he ever had a grandfather, which is doubtful. It seems uncanny to think\n" +
                "of a child at Green Gables somehow; there's never been one there, for\n" +
                "Matthew and Marilla were grown up when the new house was built--if they\n" +
                "ever _were_ children, which is hard to believe when one looks at them.\n" +
                "I wouldn't be in that orphan's shoes for anything. My, but I pity him,\n" +
                "that's what.”\n" +
                "\n" +
                "So said Mrs. Rachel to the wild rose bushes out of the fulness of her\n" +
                "heart; but if she could have seen the child who was waiting patiently\n" +
                "at the Bright River station at that very moment her pity would have been\n" +
                "still deeper and more profound.";

        Summariser summariser = new Summariser();
        summariser.summarise(text, 5);

        assertEquals(33, summariser.getNumParagraphs());
        assertEquals(138, summariser.getNumSentences());

        String expectedSummary = "MRS. Rachel Lynde lived just where the Avonlea main road dipped down into a little " +
                "hollow, fringed with alders and ladies' eardrops and traversed by a brook that had its source away " +
                "back in the woods of the old Cuthbert place; it was reputed to be an intricate, headlong brook in " +
                "its earlier course through those woods, with dark secrets of pool and cascade; but by the time it " +
                "reached Lynde's Hollow it was a quiet, well-conducted little stream, for not even a brook could " +
                "run past Mrs. Rachel Lynde's door without due regard for decency and decorum; it probably was " +
                "conscious that Mrs. Rachel was sitting at her window, keeping a sharp eye on everything that " +
                "passed, from brooks and children up, and that if she noticed anything odd or out of place she " +
                "would never rest until she had ferreted out the whys and wherefores thereof. And yet here was " +
                "Matthew Cuthbert, at half-past three on the afternoon of a busy day, placidly driving over the " +
                "hollow and up the hill; moreover, he wore a white collar and his best suit of clothes, which was " +
                "plain proof that he was going out of Avonlea; and he had the buggy and the sorrel mare, which " +
                "betokened that he was going a considerable distance. Accordingly after tea Mrs. Rachel set out; " +
                "she had not far to go; the big, rambling, orchard-embowered house where the Cuthberts lived was " +
                "a scant quarter of a mile up the road from Lynde's Hollow. She had expected Mrs. Rachel up; she had " +
                "known that the sight of Matthew jaunting off so unaccountably would be too much for her neighbor's " +
                "curiosity. So said Mrs. Rachel to the wild rose bushes out of the fulness of her heart; but if she " +
                "could have seen the child who was waiting patiently at the Bright River station at that very moment " +
                "her pity would have been still deeper and more profound.";

        assertEquals(expectedSummary, summariser.getSummary());
    }
}