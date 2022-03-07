package com.lyst.cat.data.thecatapi.dto

data class Breed(
    val id: String,
    val name: String,
    val reference_image_id: String,
    val image: BreedImage?,
    val description: String,
    val child_friendly: Int,
    val energy_level: Int,

    // not needed for this small demo::

//    val weight: BreedWeight,
    //    val adaptability: Int,
//    val affection_level: Int,
//    val alt_names: String,
//    val country_code: String,
//    val country_codes: String,
//    val dog_friendly: Int,
//    val experimental: Int,
//    val grooming: Int,
//    val hairless: Int,
//    val health_issues: Int,
//    val hypoallergenic: Int,
//    val indoor: Int,
//    val intelligence: Int,
//    val lap: Int,
//    val life_span: String,
//    val natural: Int,
//    val origin: String,
//    val rare: Int,
//    val rex: Int,
//    val shedding_level: Int,
//    val short_legs: Int,
//    val social_needs: Int,
//    val stranger_friendly: Int,
//    val suppressed_tail: Int,
//    val temperament: String,
//    val vetstreet_url: String,
//    val vocalisation: Int,
//    val wikipedia_url: String
)

data class BreedImage(
    val height: Int,
    val id: String,
    val url: String?,
    val width: Int
)

data class BreedById(
    val breeds: List<Breed>,

    val height: Int,
    val id: String,
    val url: String?,
    val width: Int
)


// not needed for this small demo::

//data class BreedWeight(
//    val imperial: String,
//    val metric: String
//)

