package id.rrlab.diffutil.data

object DataSource {
    val ratingList: List<Rating>
        get() {
            val ratings = ArrayList<Rating>()
            ratings.add(Rating(1, 10, "Rizki"))
            ratings.add(Rating(2, 12, "Rian"))
            ratings.add(Rating(3, 5, "Anandita"))
            return ratings
        }
}