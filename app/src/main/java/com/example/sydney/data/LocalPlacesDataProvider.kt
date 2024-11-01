package com.example.sydney.data

import com.example.sydney.R
import com.example.sydney.model.Place

object LocalPlacesDataProvider {
    val places: List<Place> = listOf(
        Place(
            id = 1,
            nameResourceId = R.string.coffee_shop_1_name,
            descResourceId = R.string.coffee_shop_1_desc,
            imageResourceId = R.drawable.batch_espresso_icon,
            largeImageResourceId = R.drawable.batch_espresso_details,
            categoryId = 1
        ),
        Place(
            id = 2,
            nameResourceId = R.string.coffee_shop_2_name,
            descResourceId = R.string.coffee_shop_2_desc,
            imageResourceId = R.drawable.brew_collective_icon,
            largeImageResourceId = R.drawable.brew_collective_details,
            categoryId = 1
        ),
        Place(
            id = 3,
            nameResourceId = R.string.coffee_shop_3_name,
            descResourceId = R.string.coffee_shop_3_desc,
            imageResourceId = R.drawable.leible_icon,
            largeImageResourceId = R.drawable.leible_details,
            categoryId = 1
        ),
        Place(
            id = 4,
            nameResourceId = R.string.coffee_shop_4_name,
            descResourceId = R.string.coffee_shop_4_desc,
            imageResourceId = R.drawable.locantro_icon,
            largeImageResourceId = R.drawable.locantro_details,
            categoryId = 1
        ),
        Place(
            id = 5,
            nameResourceId = R.string.restaurant_1_name,
            descResourceId = R.string.restaurant_1_desc,
            imageResourceId = R.drawable.thai_pothong_icon,
            largeImageResourceId = R.drawable.thai_pothong_details,
            categoryId = 2
        ),
        Place(
            id = 6,
            nameResourceId = R.string.restaurant_2_name,
            descResourceId = R.string.restaurant_2_desc,
            imageResourceId = R.drawable.ippudo_icon,
            largeImageResourceId = R.drawable.ippudo_details,
            categoryId = 2
        ),
        Place(
            id = 7,
            nameResourceId = R.string.restaurant_3_name,
            descResourceId = R.string.restaurant_3_desc,
            imageResourceId = R.drawable.spice_i_am_icon,
            largeImageResourceId = R.drawable.spice_i_am_details,
            categoryId = 2
        ),
        Place(
            id = 8,
            nameResourceId = R.string.restaurant_4_name,
            descResourceId = R.string.restaurant_4_desc,
            imageResourceId = R.drawable.moretti_icon,
            largeImageResourceId = R.drawable.moretti_details,
            categoryId = 2
        ),
        Place(
            id = 9,
            nameResourceId = R.string.restaurant_5_name,
            descResourceId = R.string.restaurant_5_desc,
            imageResourceId = R.drawable._678_korean_bbq_icon,
            largeImageResourceId = R.drawable._678_korean_bbq_details,
            categoryId = 2
        ),
        Place(
            id = 10,
            nameResourceId = R.string.kid_friendly_place_1_name,
            descResourceId = R.string.kid_friendly_place_1_desc,
            imageResourceId = R.drawable.luna_park_icon,
            largeImageResourceId = R.drawable.luna_park_details,
            categoryId = 3
        ),
        Place(
            id = 11,
            nameResourceId = R.string.kid_friendly_place_2_name,
            descResourceId = R.string.kid_friendly_place_2_desc,
            imageResourceId = R.drawable.strike_icon,
            largeImageResourceId = R.drawable.strike_details,
            categoryId = 3
        ),
        Place(
            id = 12,
            nameResourceId = R.string.kid_friendly_place_3_name,
            descResourceId = R.string.kid_friendly_place_3_desc,
            imageResourceId = R.drawable.koko_icon,
            largeImageResourceId = R.drawable.koko_details,
            categoryId = 3
        ),
        Place(
            id = 13,
            nameResourceId = R.string.kid_friendly_place_4_name,
            descResourceId = R.string.kid_friendly_place_4_desc,
            imageResourceId = R.drawable.event_cinemas_icon,
            largeImageResourceId = R.drawable.event_cinemas_details,
            categoryId = 3
        ),
        Place(
            id = 14,
            nameResourceId = R.string.park_1_name,
            descResourceId = R.string.park_1_desc,
            imageResourceId = R.drawable.hyde_park_icon,
            largeImageResourceId = R.drawable.hyde_park_details,
            categoryId = 4
        ),
        Place(
            id = 15,
            nameResourceId = R.string.park_2_name,
            descResourceId = R.string.park_2_desc,
            imageResourceId = R.drawable.moore_park_icon,
            largeImageResourceId = R.drawable.moore_park_details,
            categoryId = 4
        ),
        Place(
            id = 16,
            nameResourceId = R.string.park_3_name,
            descResourceId = R.string.park_3_desc,
            imageResourceId = R.drawable.botanic_garden_icon,
            largeImageResourceId = R.drawable.botanic_garden_details,
            categoryId = 4
        ),
        Place(
            id = 17,
            nameResourceId = R.string.park_4_name,
            descResourceId = R.string.park_4_desc,
            imageResourceId = R.drawable.victoria_park_icon,
            largeImageResourceId = R.drawable.victoria_park_details,
            categoryId = 4
        ),
        Place(
            id = 18,
            nameResourceId = R.string.park_5_name,
            descResourceId = R.string.park_5_desc,
            imageResourceId = R.drawable.barangaroo_reserve_icon,
            largeImageResourceId = R.drawable.barangaroo_reserve_details,
            categoryId = 4
        ),
        Place(
            id = 19,
            nameResourceId = R.string.shopping_center_1_name,
            descResourceId = R.string.shopping_center_1_desc,
            imageResourceId = R.drawable.world_square_icon,
            largeImageResourceId = R.drawable.world_square_details,
            categoryId = 5
        ),
        Place(
            id = 20,
            nameResourceId = R.string.shopping_center_2_name,
            descResourceId = R.string.shopping_center_2_desc,
            imageResourceId = R.drawable.westfield_icon,
            largeImageResourceId = R.drawable.westfield_details,
            categoryId = 5
        ),
        Place(
            id = 21,
            nameResourceId = R.string.shopping_center_3_name,
            descResourceId = R.string.shopping_center_3_desc,
            imageResourceId = R.drawable.dfo_icon,
            largeImageResourceId = R.drawable.dfo_details,
            categoryId = 5
        ),
        Place(
            id = 22,
            nameResourceId = R.string.shopping_center_4_name,
            descResourceId = R.string.shopping_center_4_desc,
            imageResourceId = R.drawable.marketplace_icon,
            largeImageResourceId = R.drawable.marketplace_details,
            categoryId = 5
        ),
    )
}