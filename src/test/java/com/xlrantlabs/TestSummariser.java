package com.xlrantlabs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestSummariser
{
    @Test
    public void testSummarise() throws Exception
    {
        String text = "In 1976, Mattel's CEO Ray Wagner declined a deal to produce a toyline of action figures based on the characters from the George Lucas film Star Wars, due to the $750,000 license required up front.[7][8] Following the commercial success of the original Star Wars trilogy and its related merchandise during the next few years, Mattel launched several successful competing toylines which captured the public's imagination and significantly influenced the toy market.[7]\n" +
                "\n" +
                "Toy designer Mark Taylor explained that the original design of He-Man in a series of sketches while working for Mattel was inspired by Cro-Magnon men and Vikings. Furthermore, his original design of Beast Man was rejected by Mattel for looking too much like Chewbacca.[9]\n" +
                "\n" +
                "In the race to design the next popular action figure, Roger Sweet (a lead designer working for Mattel's Preliminary Design Department during much of the 1970s and 1980s) realized that simplicity was the key to success.[7][8] According to his 2005 book Mastering the Universe: He-Man and the Rise and Fall of a Billion-Dollar Idea, Sweet knew that if he gave the marketing department something it could sell, he had won 90 percent of the battle.[7][10]\n" +
                "\n" +
                "According to Roger Sweet, \"The only way I was going to have a chance to sell this [to Wagner] was to make three 3D models - big ones. I glued a Big Jim figure [from another Mattel toy line] into a battle action pose and I added a lot of clay to his body. I then had plaster casts made. These three prototypes, which I presented in late 1980, brought He-Man into existence.\"\n" +
                "\n" +
                "I simply explained that this was a powerful figure that could be taken anywhere and dropped into any context because he had a generic name: He-Man![7][8]\n" +
                "\n" +
                "During the 1980s, rumors claimed that Conan the Barbarian was a source of inspiration for the He-Man character.[11] According to this rumor, Mattel had a licensing agreement to make action figures associated with the 1982 film of the same name starring Arnold Schwarzenegger. Apparently, such an idea had to be modified in order to avoid objections from parents concerned that a toyline for children was promoting a film containing nudity and brutal, graphic violence.\n" +
                "\n" +
                "Sweet refuted the rumor, saying that he conceptualized and developed the He-Man/Masters of the Universe franchise in late 1980 (two years before the release of the Universal Pictures film). The toyline existed prior to the film, beginning production in 1981 and marketing in 1982. At that time, Mattel did not have a license with Universal to make toys for the film, which resulted in Conan Properties International suing Mattel over copyright infringement, due to He-Man's similarities to Conan.[12]\n" +
                "\n" +
                "From the lawsuit of CPI vs. Mattel:\n" +
                "\n" +
                "In 1980, CPI, through its agent, Conan Licensing Company (\"CLC\"), began negotiations with Mattel regarding the possible licensing to Mattel of certain toy rights in CONAN. During this time, Mattel received a substantial quantity of material on the CONAN character. On July 31, 1981, CPI and Mattel executed a License Agreement whereby Mattel was granted \"the right to make and sell certain plastic action figures of CONAN and ancillary characters as depicted in the CONAN movie.\" Amended Complaint, para. 12. The Agreement provided, however, \"that nothing in the License should be construed as an assignment or grant to Mattel of any right, title or interest in or to CONAN, and that all rights relating thereto were reserved by CPI (except only for the licensee to use the property as specifically agreed to).\" Amended Complaint, para. 14. It was also agreed that, after the termination of the License Agreement, Mattel would not make or sell any CONAN toys.\n" +
                "\n" +
                "In January 1982, Mattel requested that the License Agreement be terminated. On April 14, 1982, CPI and Mattel entered into a termination agreement which provided that \"all materials created and or developed by Mattel for use in connection with products under the CONAN License\" would be delivered to CPI's agent, CPC, which would have \"the exclusive right to use such material.\" Amended Complaint, para. 17.\n" +
                "\n" +
                "In February 1983, Mattel introduced \"He-Man,\"a fantasy character as part of its new \"Masters of the Universe\" toy line of action figures. Since that time, Mattel has also featured He-Man and the other Masters of the Universe characters in, inter alia, a television series, comic books, and video tapes. Thereafter, CPI commenced this action asserting that these figures are copies of CONAN, were created under the License, and are CPI's property. Amended Complaint, paras. 20, 21.\n" +
                "Mattel won the lawsuit against Conan Properties, retaining the rights over He-Man and the Masters of the Universe.[12]\n" +
                "\n" +
                "Originally, He-Man was presented to Mattel executives not as drawings and wax models, but in the form of the He-Man Trio: three figures of three-dimensional prototype models depicting He-Man as a barbarian, a soldier and a spaceman. Out of the three concepts, the barbarian version was chosen to be the basis for the toyline. Considering that the Conan character was created almost 50 years before the development of the He-Man franchise, it is possible that the Masters of the Universe borrowed many aspects from Conan; however, it was not intended to be a toyline for the film after legal agreements were dissolved.[12] Additionally, Roger Sweet has also claimed that he was \"really impressed\" by the paintings of fantasy artist Frank Frazetta when creating He-Man.[8] Expanding further on the barbarian theme, Mattel hired comic-book writers and artists such as Donald F. Glut and even Earl Norem and Alfredo Alcala (who were both still working on the Savage Sword of Conan comics since the mid-1970s) to create additional characters (along with their back stories), posters, package inlays, box art and mini-comics for distribution with the action figures.";
        new Summariser().summarise(text, 5);
    }
}