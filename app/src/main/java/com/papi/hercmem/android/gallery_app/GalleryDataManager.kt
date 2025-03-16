package com.papi.hercmem.android.gallery_app

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

object GalleryDataManager {

    private const val DATABASE_NAME = "paintingdb"
    private const val DATABASE_VERSION = 1
    private const val TABLE_NAME = "paintingTable"

    private const val COLUMN_ID = "id"
    private const val COLUMN_NAME = "name"
    private const val COLUMN_ARTIST = "artist"
    private const val COLUMN_DESCRIPTION = "description"
    private const val COLUMN_IMAGE = "image"

    private var dbHelper: DBHelper? = null

    // Aρχικοποίηση των δεδομένων στη βάση αν δεν υπάρχουν
    fun initializeData(context: Context) {
        dbHelper = DBHelper(context)
        val db = dbHelper?.writableDatabase

        if (db != null) {
            // Έλεγχος αν υπάρχουν ήδη δεδομένα στον πίνακα
            val cursor = db.query(TABLE_NAME, null, null, null, null, null, null)
            if (cursor.count == 0) { // Αν ο πίνακας είναι άδειος, εισάγουμε τα δεδομένα
                insertPainting(db, "The Street", "Vincent van Gogh", "In May 1888, Van Gogh rented four rooms in a house on Place Lamartine in Arles " +
                        "(southern France). The green shutters in this painting of the square show where he lived. Shortly after moving into " +
                        "the ‘Yellow House’, he sent Theo a description and sketch of his painting of it: ‘it’s tremendous, these yellow " +
                        "houses in the sunlight and then the incomparable freshness of the blue.’", "the_street")

                insertPainting(db, "The Bedroom", "Vincent van Gogh", "While he was in Arles, Van Gogh made this painting of his bedroom in the Yellow" +
                        " House. He prepared the room himself with simple furniture and with his own work on the wall. The bright colours " +
                        "were meant to express absolute ‘repose’ or ‘sleep’. Research shows that the strongly contrasting colours we see " +
                        "in the work today are the result of discolouration over the years. The walls and doors, for instance, were " +
                        "originally purple rather than blue. The apparently odd angle of the rear wall, meanwhile, is not a mistake on " +
                        "Van Gogh’s part – the corner really was skewed. The rules of perspective seem not to have been accurately applied " +
                        "throughout the painting, but this was a deliberate choice. Vincent told Theo in a letter that he had deliberately " +
                        "‘flattened’ the interior and left out the shadows so that his picture would resemble a Japanese print. Van Gogh was " +
                        "very pleased with the painting: ‘When I saw my canvases again after my illness, what seemed to me the best was " +
                        "the bedroom.’", "the_bedroom")

                insertPainting(db, "Wheatfield with a Reaper", "Vincent van Gogh", "Van Gogh painted this walled field from his hospital room. For the first few months" +
                        " that he was there, " +
                        "he was not allowed to leave the grounds.\n" +
                        "\n" +
                        "The reaper labours in the heat of the sun. The wheat, painted with thick gobs of yellow, undulates around him. " +
                        "For Van Gogh, wheat was a symbol of the eternal cycle of nature and the transience of life. He saw the reaper as " +
                        "'the image of death . . . in this sense that humanity would be the wheat being reaped.'\n" +
                        "\n" +
                        "He added, however, that this death was 'almost smiling. It's all yellow except for a line of violet hills – a pale," +
                        " blond yellow. I myself find that funny, that I saw it like that through the iron bars of a cell.'", "wheatfield_with_a_reaper")

                insertPainting(db, "Almond Blossom", "Vincent van Gogh", "Large blossom branches like this against a blue sky were one of Van Gogh’s favourite " +
                        "subjects. Almond trees flower early in the spring making them a symbol of new life. Van Gogh borrowed the subject, " +
                        "the bold outlines and the positioning of the tree in the picture plane from Japanese printmaking.\n" +
                        "\n" +
                        "The painting was a gift for his brother Theo and sister-in-law Jo, who had just had a baby son, Vincent Willem. " +
                        "In the letter announcing the new arrival, Theo wrote: ‘As we told you, we’ll name him after you, and I’m making " +
                        "the wish that he may be as determined and as courageous as you.’ Unsurprisingly, it was this work that remained " +
                        "closest to the hearts of the Van Gogh family. Vincent Willem went on to found the Van Gogh Museum.", "almond_blossom")

                insertPainting(db, "Sunflowers", "Vincent van Gogh", "Van Gogh’s paintings of Sunflowers are among his most famous. He did them in Arles, " +
                        "in the south of France, in 1888 and 1889. Vincent painted a total of five large canvases with sunflowers in a vase, " +
                        "with three shades of yellow ‘and nothing else’. In this way, he demonstrated that it was possible to create an image " +
                        "with numerous variations of a single colour, without any loss of eloquence.\n" +
                        "\n" +
                        "The sunflower paintings had a special significance for Van Gogh: they communicated ‘gratitude’, he wrote. He hung " +
                        "the first two in the room of his friend, the painter Paul Gauguin, who came to live with him for a while in the " +
                        "Yellow House. Gauguin was impressed by the sunflowers, which he thought were ‘completely Vincent’. Van Gogh had " +
                        "already painted a new version during his friend’s stay and Gauguin later asked for one as a gift, which Vincent " +
                        "was reluctant to give him. He later produced two loose copies, however, one of which is now in the Van Gogh Museum.", "sunflowers")

                insertPainting(db, "The Sower", "Vincent van Gogh", "Van Gogh had a special interest in sowers throughout his artistic career. All in all, " +
                        "he made more than 30 drawings and paintings on this theme. He painted this sower in the autumn of 1888. At the time, " +
                        "Van Gogh was working together with Paul Gauguin (1848-1903). Gauguin believed that in his work Van Gogh should draw " +
                        "less on reality and more on his imagination.\n" +
                        "\n" +
                        "Here, Van Gogh used colours meant to express emotion and passion. He assigned the leading roles to the greenish-yellow " +
                        "of the sky and the purple of the field. The bright yellow sun looks like a halo, turning the sower into a saint.", "the_sower")

                insertPainting(db, "Garden with Courting Couples: Square Saint-Pierre", "Vincent van Gogh", "Van Gogh called this sunny park scene 'the painting of the garden with lovers'. " +
                        "Couples in love are strolling under the young chestnut trees and sitting along the winding paths.\n" +
                        "\n" +
                        "He used a free variation on the technique of the Pointillists. They built up their compositions from dots of paint. " +
                        "Van Gogh instead applied small brushstrokes of varying length in different directions. This helped him to create " +
                        "the effect of a radiant spring day, which fit the sense of intimacy and togetherness he wished to express. He too " +
                        "longed for a wife and a family, but he had 'the most impossible love affairs'. He eventually resigned himself to the " +
                        "situation; he was devoted to his art.", "garden_with_courting_couples")

                insertPainting(db, "Vincent van Gogh Painting Sunflowers", "Paul Gauguin", "Was Van Gogh really painting a vase of sunflowers when his friend Gauguin produced " +
                        "this portrait of him? No, he can’t have been: it was December and far too late in the year for sunflowers. But it’s " +
                        "quite probable that Van Gogh painted a copy of one of his own sunflower pictures around this time. The landscape in " +
                        "the background is also fictional: unlike Van Gogh, Gauguin liked to work from his imagination. They often argued " +
                        "about this. This painting refers to their disagreement.\n" +
                        "\n" +
                        "Later, Van Gogh wrote about this portrait: ‘My face has lit up a lot since, but it was indeed me, extremely tired " +
                        "and charged with electricity as I was then.’", "van_gogh_painting_sunflowers")

                insertPainting(db, "Haymaking", "Léon-Augustin Lhermitte", "This enormous painting by the French artist Léon Lhermitte shows a family of " +
                        "peasants resting during haymaking. The work probably has a symbolic element too, evoking youth, maturity and " +
                        "old age. The old man at the front holds a scythe, a traditional symbol of approaching death. This kind of symbolism " +
                        "and the emphasis on the romantic, idyllic side of peasant life made works of this type extremely popular in the " +
                        "late nineteenth century. The Haymakers won the Grand Prix at the 1889 World Exhibition in Paris.\n" +
                        "\n" +
                        "Lhermitte became a famous painter of rural life. According to Vincent van Gogh, the French artist’s secret was " +
                        "‘that he knows the figure in general – namely the sturdy, severe workman’s figure – through and through, and " +
                        "takes his subjects from the heart of the people.’\n" +
                        "\n" +
                        "Van Gogh too hoped to establish himself as a painter of peasant life, and so Lhermitte’s work was an important " +
                        "source of inspiration to him. He regularly asked his brother Theo to send him reproductions of Lhermitte’s paintings.", "haymaking")

                insertPainting(db, "The Potato Eaters", "Vincent van Gogh", "Van Gogh saw the Potato Eaters as a showpiece, for which he deliberately chose a " +
                        "difficult composition to prove he was on his way to becoming a good figure painter. The painting had to depict the " +
                        "harsh reality of country life, so he gave the peasants coarse faces and bony, working hands. He wanted to show in " +
                        "this way that they ‘have tilled the earth themselves with these hands they are putting in the dish ... that they " +
                        "have thus honestly earned their food’.\n" +
                        "\n" +
                        "He painted the five figures in earth colours – ‘something like the colour of a really dusty potato, unpeeled of " +
                        "course’. The message of the painting was more important to Van Gogh than correct anatomy or technical perfection. " +
                        "He was very pleased with the result: yet his painting drew considerable criticism because its colours were so dark " +
                        "and the figures full of mistakes. Nowadays, the Potato Eaters is one of Van Gogh’s most famous works.", "the_potato_eaters")

            }
            cursor.close()
            db.close()
        }
    }

    // Μέθοδος εισαγωγής των δεδομένων στον πίνακα
    private fun insertPainting(db: SQLiteDatabase, name: String, artist: String, description: String, image: String) {
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_ARTIST, artist)
            put(COLUMN_DESCRIPTION, description)
            put(COLUMN_IMAGE, image)
        }
        db.insert(TABLE_NAME, null, values)
    }

    // Μέθοδος για ανάκτηση των δεδομένων
    fun getPaintingsData(context: Context): List<Painting> {
        val db = dbHelper?.readableDatabase
        val paintingsList = mutableListOf<Painting>()

        db?.let {
            val cursor = it.query(TABLE_NAME, null, null, null, null, null, null)
            if (cursor.moveToFirst()) {
                do {
                    val name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
                    val artist = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ARTIST))
                    val description = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION))
                    val image = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_IMAGE))

                    paintingsList.add(Painting(name, artist, description, image))
                } while (cursor.moveToNext())
            }
            cursor.close()
        }

        return paintingsList
    }

    // Βοηθητική κλάση για τη διαχείριση της βάσης δεδομένων
    private class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
        override fun onCreate(db: SQLiteDatabase) {
            val createTableQuery = """
                CREATE TABLE $TABLE_NAME (
                    $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                    $COLUMN_NAME TEXT,
                    $COLUMN_ARTIST TEXT,
                    $COLUMN_DESCRIPTION TEXT,
                    $COLUMN_IMAGE TEXT
                )
            """.trimIndent()
            db.execSQL(createTableQuery)
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
            db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            onCreate(db)
        }
    }
}

// Μοντέλο δεδομένων για έναν πίνακα
data class Painting(
    val name: String,
    val artist: String,
    val description: String,
    val image: String
)


































/*
package com.papi.hercmem.android.gallery_app

import android.content.Context
import android.content.SharedPreferences
import org.json.JSONArray
import org.json.JSONObject

object GalleryDataManager {

    private const val SHARED_PREFS_NAME = "PaintingsData"
    private const val PAINTINGS_KEY = "Paintings"

    fun initializeData(context: Context){
        val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()
        if (!sharedPreferences.contains(PAINTINGS_KEY)) {
            val paintingsArray = JSONArray()

            try {
                val painting1 = JSONObject()
                painting1.put("name", "The Street")
                painting1.put("artist", "Vincent van Gogh")
                painting1.put("description", "In May 1888, Van Gogh rented four rooms in a house on Place Lamartine in Arles " +
                        "(southern France). The green shutters in this painting of the square show where he lived. Shortly after moving into " +
                        "the ‘Yellow House’, he sent Theo a description and sketch of his painting of it: ‘it’s tremendous, these yellow " +
                        "houses in the sunlight and then the incomparable freshness of the blue.’")
                painting1.put("image", "the_street") // Το όνομα της εικόνας στο drawable

                val painting2 = JSONObject()
                painting2.put("name", "The Bedroom")
                painting2.put("artist", "Vincent van Gogh")
                painting2.put("description", "While he was in Arles, Van Gogh made this painting of his bedroom in the Yellow" +
                        " House. He prepared the room himself with simple furniture and with his own work on the wall. The bright colours " +
                        "were meant to express absolute ‘repose’ or ‘sleep’. Research shows that the strongly contrasting colours we see " +
                        "in the work today are the result of discolouration over the years. The walls and doors, for instance, were " +
                        "originally purple rather than blue. The apparently odd angle of the rear wall, meanwhile, is not a mistake on " +
                        "Van Gogh’s part – the corner really was skewed. The rules of perspective seem not to have been accurately applied " +
                        "throughout the painting, but this was a deliberate choice. Vincent told Theo in a letter that he had deliberately " +
                        "‘flattened’ the interior and left out the shadows so that his picture would resemble a Japanese print. Van Gogh was " +
                        "very pleased with the painting: ‘When I saw my canvases again after my illness, what seemed to me the best was " +
                        "the bedroom.’")
                painting2.put("image", "the_bedroom") // Το όνομα της εικόνας στο drawable

                val painting3 = JSONObject()
                painting3.put("name", "Wheatfield with a Reaper")
                painting3.put("artist", "Vincent van Gogh")
                painting3.put("description","Van Gogh painted this walled field from his hospital room. For the first few months" +
                        " that he was there, " +
                        "he was not allowed to leave the grounds.\n" +
                        "\n" +
                        "The reaper labours in the heat of the sun. The wheat, painted with thick gobs of yellow, undulates around him. " +
                        "For Van Gogh, wheat was a symbol of the eternal cycle of nature and the transience of life. He saw the reaper as " +
                        "'the image of death . . . in this sense that humanity would be the wheat being reaped.'\n" +
                        "\n" +
                        "He added, however, that this death was 'almost smiling. It's all yellow except for a line of violet hills – a pale," +
                        " blond yellow. I myself find that funny, that I saw it like that through the iron bars of a cell.'")
                painting3.put("image", "wheatfield_with_a_reaper") // Το όνομα της εικόνας στο drawable

                val painting4 = JSONObject()
                painting4.put("name", "Almond Blossom")
                painting4.put("artist", "Vincent van Gogh")
                painting4.put("description","Large blossom branches like this against a blue sky were one of Van Gogh’s favourite " +
                        "subjects. Almond trees flower early in the spring making them a symbol of new life. Van Gogh borrowed the subject, " +
                        "the bold outlines and the positioning of the tree in the picture plane from Japanese printmaking.\n" +
                        "\n" +
                        "The painting was a gift for his brother Theo and sister-in-law Jo, who had just had a baby son, Vincent Willem. " +
                        "In the letter announcing the new arrival, Theo wrote: ‘As we told you, we’ll name him after you, and I’m making " +
                        "the wish that he may be as determined and as courageous as you.’ Unsurprisingly, it was this work that remained " +
                        "closest to the hearts of the Van Gogh family. Vincent Willem went on to found the Van Gogh Museum.")
                painting4.put("image", "almond_blossom") // Το όνομα της εικόνας στο drawable

                val painting5 = JSONObject()
                painting5.put("name", "Sunflowers")
                painting5.put("artist", "Vincent van Gogh")
                painting5.put("description","Van Gogh’s paintings of Sunflowers are among his most famous. He did them in Arles, " +
                        "in the south of France, in 1888 and 1889. Vincent painted a total of five large canvases with sunflowers in a vase, " +
                        "with three shades of yellow ‘and nothing else’. In this way, he demonstrated that it was possible to create an image " +
                        "with numerous variations of a single colour, without any loss of eloquence.\n" +
                        "\n" +
                        "The sunflower paintings had a special significance for Van Gogh: they communicated ‘gratitude’, he wrote. He hung " +
                        "the first two in the room of his friend, the painter Paul Gauguin, who came to live with him for a while in the " +
                        "Yellow House. Gauguin was impressed by the sunflowers, which he thought were ‘completely Vincent’. Van Gogh had " +
                        "already painted a new version during his friend’s stay and Gauguin later asked for one as a gift, which Vincent " +
                        "was reluctant to give him. He later produced two loose copies, however, one of which is now in the Van Gogh Museum.")
                painting5.put("image", "sunflowers") // Το όνομα της εικόνας στο drawable

                val painting6 = JSONObject()
                painting6.put("name", "The Sower")
                painting6.put("artist", "Vincent van Gogh")
                painting6.put("description","Van Gogh had a special interest in sowers throughout his artistic career. All in all, " +
                        "he made more than 30 drawings and paintings on this theme. He painted this sower in the autumn of 1888. At the time, " +
                        "Van Gogh was working together with Paul Gauguin (1848-1903). Gauguin believed that in his work Van Gogh should draw " +
                        "less on reality and more on his imagination.\n" +
                        "\n" +
                        "Here, Van Gogh used colours meant to express emotion and passion. He assigned the leading roles to the greenish-yellow " +
                        "of the sky and the purple of the field. The bright yellow sun looks like a halo, turning the sower into a saint.") // Το όνομα της εικόνας στο drawable
                painting6.put("image", "the_sower") // Το όνομα της εικόνας στο drawable

                val painting7 = JSONObject()
                painting7.put("name", "Garden with Courting Couples: Square Saint-Pierre")
                painting7.put("artist", "Vincent van Gogh")
                painting7.put("description","Van Gogh called this sunny park scene 'the painting of the garden with lovers'. " +
                        "Couples in love are strolling under the young chestnut trees and sitting along the winding paths.\n" +
                        "\n" +
                        "He used a free variation on the technique of the Pointillists. They built up their compositions from dots of paint. " +
                        "Van Gogh instead applied small brushstrokes of varying length in different directions. This helped him to create " +
                        "the effect of a radiant spring day, which fit the sense of intimacy and togetherness he wished to express. He too " +
                        "longed for a wife and a family, but he had 'the most impossible love affairs'. He eventually resigned himself to the " +
                        "situation; he was devoted to his art.")
                painting7.put("image", "garden_with_courting_couples") // Το όνομα της εικόνας στο drawable

                val painting8 = JSONObject()
                painting8.put("name", "Vincent van Gogh Painting Sunflowers")
                painting8.put("artist", "Paul Gauguin")
                painting8.put("description","Was Van Gogh really painting a vase of sunflowers when his friend Gauguin produced " +
                        "this portrait of him? No, he can’t have been: it was December and far too late in the year for sunflowers. But it’s " +
                        "quite probable that Van Gogh painted a copy of one of his own sunflower pictures around this time. The landscape in " +
                        "the background is also fictional: unlike Van Gogh, Gauguin liked to work from his imagination. They often argued " +
                        "about this. This painting refers to their disagreement.\n" +
                        "\n" +
                        "Later, Van Gogh wrote about this portrait: ‘My face has lit up a lot since, but it was indeed me, extremely tired " +
                        "and charged with electricity as I was then.’")
                painting8.put("image", "van_gogh_painting_sunflowers") // Το όνομα της εικόνας στο drawable

                val painting9 = JSONObject()
                painting9.put("name", "Haymaking")
                painting9.put("artist", "Léon-Augustin Lhermitte")
                painting9.put("description","This enormous painting by the French artist Léon Lhermitte shows a family of " +
                        "peasants resting during haymaking. The work probably has a symbolic element too, evoking youth, maturity and " +
                        "old age. The old man at the front holds a scythe, a traditional symbol of approaching death. This kind of symbolism " +
                        "and the emphasis on the romantic, idyllic side of peasant life made works of this type extremely popular in the " +
                        "late nineteenth century. The Haymakers won the Grand Prix at the 1889 World Exhibition in Paris.\n" +
                        "\n" +
                        "Lhermitte became a famous painter of rural life. According to Vincent van Gogh, the French artist’s secret was " +
                        "‘that he knows the figure in general – namely the sturdy, severe workman’s figure – through and through, and " +
                        "takes his subjects from the heart of the people.’\n" +
                        "\n" +
                        "Van Gogh too hoped to establish himself as a painter of peasant life, and so Lhermitte’s work was an important " +
                        "source of inspiration to him. He regularly asked his brother Theo to send him reproductions of Lhermitte’s paintings.")
                painting9.put("image", "haymaking") // Το όνομα της εικόνας στο drawable

                val painting10 = JSONObject()
                painting10.put("name", "The Potato Eaters")
                painting10.put("artist", "Vincent van Gogh")
                painting10.put("description","Van Gogh saw the Potato Eaters as a showpiece, for which he deliberately chose a " +
                        "difficult composition to prove he was on his way to becoming a good figure painter. The painting had to depict the " +
                        "harsh reality of country life, so he gave the peasants coarse faces and bony, working hands. He wanted to show in " +
                        "this way that they ‘have tilled the earth themselves with these hands they are putting in the dish ... that they " +
                        "have thus honestly earned their food’.\n" +
                        "\n" +
                        "He painted the five figures in earth colours – ‘something like the colour of a really dusty potato, unpeeled of " +
                        "course’. The message of the painting was more important to Van Gogh than correct anatomy or technical perfection. " +
                        "He was very pleased with the result: yet his painting drew considerable criticism because its colours were so dark " +
                        "and the figures full of mistakes. Nowadays, the Potato Eaters is one of Van Gogh’s most famous works.")
                painting10.put("image", "the_potato_eaters") // Το όνομα της εικόνας στο drawable

                paintingsArray.put(painting1)
                paintingsArray.put(painting2)
                paintingsArray.put(painting3)
                paintingsArray.put(painting4)
                paintingsArray.put(painting5)
                paintingsArray.put(painting6)
                paintingsArray.put(painting7)
                paintingsArray.put(painting8)
                paintingsArray.put(painting9)
                paintingsArray.put(painting10)

                // Αποθήκευση δεδομένων στο SharedPreferences
                sharedPreferences.edit()
                    .putString(PAINTINGS_KEY, paintingsArray.toString())
                    .apply()

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getPaintingsData(context: Context): JSONArray {
        val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)
        val jsonData = sharedPreferences.getString(PAINTINGS_KEY, "[]")
        return JSONArray(jsonData)
    }


}
*/