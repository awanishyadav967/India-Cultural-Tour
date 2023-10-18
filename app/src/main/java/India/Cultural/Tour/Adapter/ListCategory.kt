package India.Cultural.Tour.Adapter

import India.Cultural.Tour.R
import India.Cultural.Tour.data.Category

class ListCategory {

    var ListCategory: MutableList<Category> = ArrayList()


    fun initListCategory()
    {
        ListCategory.add(
            Category(
                NomCategory = "Temple",
                IconCategory = R.drawable.icon_beach
            )
        )
        ListCategory.add(
            Category(
                NomCategory = "Culture",
                IconCategory = R.drawable.icon_history
            )
        )
        ListCategory.add(
            Category(
                NomCategory = "Nature",
                IconCategory = R.drawable.icon_nature
            )

        )
        ListCategory.add(
            Category(
                NomCategory = "Arts",
                IconCategory = R.drawable.icon_arts
            )
        )
        ListCategory.add(
            Category(
                NomCategory = "Food",
                IconCategory = R.drawable.icon_restau
            )
        )
        ListCategory.add(
            Category(
                NomCategory = "Activite",
                IconCategory = R.drawable.icon_sport
            )
        )
        ListCategory.add(
            Category(
                NomCategory = "Cloths",
                IconCategory = R.drawable.icon_sahara
            )

        )
    }
}