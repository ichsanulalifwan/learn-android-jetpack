package com.dicoding.picodiploma.moviecatalogue2.utils

import com.dicoding.picodiploma.moviecatalogue2.data.MovieResultsItem
import com.dicoding.picodiploma.moviecatalogue2.data.TvShowResultsItem
import com.dicoding.picodiploma.moviecatalogue2.data.response.GenresItem
import com.dicoding.picodiploma.moviecatalogue2.data.response.MovieDetailResponse
import com.dicoding.picodiploma.moviecatalogue2.data.response.TvShowDetailResponse

object DataDummy {

    fun generateDummyMovies(): List<MovieResultsItem> {

        val movies = ArrayList<MovieResultsItem>()

        movies.add(
            MovieResultsItem(
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "2021-04-29",
                567189,
                "Tom Clancy's Without Remorse",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rEm96ib0sPiZBADNKBHKBv5bve9.jpg"
            )
        )

        movies.add(
            MovieResultsItem(
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018",
                11,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"
            )
        )

        movies.add(
            MovieResultsItem(
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "2021",
                12,
                "Raya and the Last Dragon",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg"
            )
        )
        return movies
    }

    fun generateDummyTvShow(): List<TvShowResultsItem> {

        val tvshow = ArrayList<TvShowResultsItem>()

        tvshow.add(
            TvShowResultsItem(
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "The Falcon and the Winter Soldier",
                88396,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
            )
        )


        tvshow.add(
            TvShowResultsItem(
                "2015",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "Supergirl",
                22,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zsaiq8ZclPuneuN7loLEbsh1ANJ.jpg"
            )
        )

        tvshow.add(
            TvShowResultsItem(
                "2019",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "The Umbrella Academy",
                23,
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg"
            )
        )
        return tvshow
    }

    fun generateDummyDetailMovies(): List<MovieDetailResponse> {

        val detailMovies = ArrayList<MovieDetailResponse>()

        detailMovies.add(
            MovieDetailResponse(
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "2021-04-29",
                generateDummyGenres(),
                7.3,
                109,
                "",
                567189,
                "Tom Clancy's Without Remorse",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "Released"
            )
        )

        detailMovies.add(
            MovieDetailResponse(
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2018",
                generateDummyGenres(),
                6.6,
                134,
                "Fate of One. Future of All.",
                11,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Released"
            )
        )

        detailMovies.add(
            MovieDetailResponse(
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "2021",
                generateDummyGenres(),
                7.4,
                107,
                "A quest to save her world.",
                12,
                "Raya and the Last Dragon",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                "Released"
            )
        )
        return detailMovies
    }

    fun generateDummyDetailTv(): List<TvShowDetailResponse> {

        val detailTv = ArrayList<TvShowDetailResponse>()

        detailTv.add(
            TvShowDetailResponse(
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                6,
                "Scripted",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                generateDummyGenres(),
                7.9,
                "The Falcon and the Winter Soldier",
                "Honor the shield",
                88396,
                1,
                "Ended"
            )
        )

        detailTv.add(
            TvShowDetailResponse(
                "2015",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                118,
                "Scripted",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zsaiq8ZclPuneuN7loLEbsh1ANJ.jpg",
                generateDummyGenres(),
                6.12,
                "Supergirl",
                "A force against fear",
                22,
                6,
                "Returning Series"
            )
        )

        detailTv.add(
            TvShowDetailResponse(
                "2019",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                20,
                "Scripted",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
                generateDummyGenres(),
                8.7,
                "The Umbrella Academy",
                "Super. Dysfunctional. Family.",
                23,
                2,
                "Returning Series"
            )
        )
        return detailTv
    }

    fun generateDummyGenres(): List<GenresItem> {

        val genreItem = ArrayList<GenresItem>()

        genreItem.add(
            GenresItem(
                "Action",
                28
            )
        )

        genreItem.add(
            GenresItem(
                "Adventure",
                12
            )
        )

        genreItem.add(
            GenresItem(
                "Thriller",
                53
            )
        )

        genreItem.add(
            GenresItem(
                "War",
                10752
            )
        )
        return genreItem
    }
}