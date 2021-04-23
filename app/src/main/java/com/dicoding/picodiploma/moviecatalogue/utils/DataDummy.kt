package com.dicoding.picodiploma.moviecatalogue.utils

import com.dicoding.picodiploma.moviecatalogue.R
import com.dicoding.picodiploma.moviecatalogue.data.MovieEntity
import com.dicoding.picodiploma.moviecatalogue.data.TvShowEntity

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "m1",
                "Alita: Battle Angel",
                "Action, Science Fiction, Adventure",
                "An angel falls. A warrior rises",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "2h 2m", 2019,
                R.drawable.poster_alita
            )
        )

        movies.add(
            MovieEntity(
                "m2",
                "Aquaman",
                "Action, Adventure, Fantasy",
                "Home Is Calling",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "2h 23m", 2018,
                R.drawable.poster_aquaman
            )
        )

        movies.add(
            MovieEntity(
                "m3",
                "A Star Is Born",
                "Drama, Romance, Music",
                " ",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "2h 16m", 2018,
                R.drawable.poster_a_start_is_born
            )
        )

        movies.add(
            MovieEntity(
                "m4",
                "Bohemian Rhapsody",
                "Music, Drama, History",
                "Fearless lives forever",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2h 15m", 2018,
                R.drawable.poster_bohemian
            )
        )

        movies.add(
            MovieEntity(
                "m5",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Adventure, Fantasy, Drama",
                "Fate of One. Future of All",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "2h 14m", 2018,
                R.drawable.poster_crimes
            )
        )

        movies.add(
            MovieEntity(
                "m6",
                "Glass",
                "Thriller, Drama, Science Fiction",
                "You Cannot Contain What You Are",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "2h 9m", 2019,
                R.drawable.poster_glass
            )
        )

        movies.add(
            MovieEntity(
                "m7",
                "Avengers: Infinity War",
                "Adventure, Action, Science Fiction",
                "An entire universe. Once and for all",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2h 29m", 2018,
                R.drawable.poster_infinity_war
            )
        )

        movies.add(
            MovieEntity(
                "m8",
                "Mortal Engines",
                "Adventure, Science Fiction",
                "Some scars never heal",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "2h 9m", 2018,
                R.drawable.poster_mortal_engines
            )
        )

        movies.add(
            MovieEntity(
                "m9",
                "Raya and the Last Dragon",
                "Animation, Adventure, Fantasy, Family, Action",
                "A quest to save her world",
                "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "1h 47m", 2021,
                R.drawable.poster_raya_and_the_last_dragon
            )
        )

        movies.add(
            MovieEntity(
                "m10",
                "Robin Hood ",
                "Adventure, Action, Thriller",
                "The legend you know. The story you don't",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "1h 56m", 2018,
                R.drawable.poster_robin_hood
            )
        )

        return movies
    }

    fun generateDummyTvShow(): List<TvShowEntity> {

        val tvshow = ArrayList<TvShowEntity>()

        tvshow.add(
            TvShowEntity(
                "t1",
                "Arrow",
                "Crime, Drama, Mystery, Action & Adventure",
                "Heroes fall. Legends rise",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "42m",
                2012,
                8,
                R.drawable.poster_arrow
            )
        )

        tvshow.add(
            TvShowEntity(
                "t2",
                "Doom Patrol",
                "Sci-Fi & Fantasy, Comedy, Drama",
                " ",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "60m",
                2019,
                2,
                R.drawable.poster_doom_patrol
            )
        )

        tvshow.add(
            TvShowEntity(
                "t3",
                "Gotham",
                "Drama, Crime, Sci-Fi & Fantasy",
                "Before Batman, there was Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "42m",
                2014,
                5,
                R.drawable.poster_gotham
            )
        )

        tvshow.add(
            TvShowEntity(
                "t4",
                "Hanna",
                "Action & Adventure, Drama",
                " ",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "60m",
                2019,
                3,
                R.drawable.poster_hanna
            )
        )

        tvshow.add(
            TvShowEntity(
                "t5",
                "Riverdale",
                "Mystery, Drama, Crime",
                "Small town. Big secrets",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "45m",
                2017,
                6,
                R.drawable.poster_riverdale
            )
        )

        tvshow.add(
            TvShowEntity(
                "t6",
                "Shameless",
                "Drama, Comedy",
                "The Gallaghers. Absolutely, Wildly, Unapologetically... Shameless",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                "46m",
                2011,
                11,
                R.drawable.poster_shameless
            )
        )

        tvshow.add(
            TvShowEntity(
                "t7",
                "Supergirl",
                "Drama, Sci-Fi & Fantasy, Action & Adventure",
                "A force against fear",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "43m",
                2015,
                6,
                R.drawable.poster_supergirl
            )
        )

        tvshow.add(
            TvShowEntity(
                "t8",
                "Supernatural",
                "Drama, Mystery, Sci-Fi & Fantasy",
                "Between darkness and deliverance",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "44m",
                2004,
                15,
                R.drawable.poster_supernatural
            )
        )

        tvshow.add(
            TvShowEntity(
                "t9",
                "The Umbrella Academy",
                "Action & Adventure, Sci-Fi & Fantasy, Drama",
                "Super. Dysfunctional. Family",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "1h",
                2019,
                3,
                R.drawable.poster_the_umbrella
            )
        )

        tvshow.add(
            TvShowEntity(
                "t10",
                "The Walking Dead",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "Fight the dead. Fear the living",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "44m",
                2010,
                11,
                R.drawable.poster_the_walking_dead
            )
        )

        return tvshow
    }
}