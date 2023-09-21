package com.example.composetutorial.provider

import com.example.composetutorial.R
import com.example.composetutorial.data.CategoryModel
import com.example.composetutorial.data.JobModel

fun getCategoryData(): MutableList<CategoryModel> {
    return mutableListOf<CategoryModel>().apply {
        add(
            CategoryModel(
                name = "Women Clothing & Other",
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/advertise/gallery/05s5Wp8w971670926700.jpeg"
            )
        )

        add(
            CategoryModel(
                name = "Men Clothing & Other",
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/advertise/gallery/05s5Wp8w971670926700.jpeg"
            )
        )
        add(
            CategoryModel(
                name = "Children Clothing",
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/advertise/gallery/05s5Wp8w971670926700.jpeg"
            )
        )
        add(
            CategoryModel(
                name = "Game Toys",
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/advertise/gallery/1192035678.jpg"
            )
        )

        add(
            CategoryModel(
                name = "Beauty Material & Spa",
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/advertise/gallery/05s5Wp8w971670926700.jpeg"
            )
        )

        add(
            CategoryModel(
                name = "Assorted Attires/Unisex Accessories",
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/advertise/gallery/133451389.jpg"
            )
        )

        add(
            CategoryModel(
                name = "Other",
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/advertise/gallery/20221207185457jdr97kfopc.jpg"
            )
        )
    }
}

fun getJobData(): MutableList<JobModel> {
    return mutableListOf<JobModel>().apply {
        add(
            JobModel(
                image = R.drawable.place_holder,
                title = "Washing Machine Repair",
                id = "ABCDE21656",
                type = "Electrical",
                date = "31 Aug 2023"
            )
        )

        add(
            JobModel(
                image = R.drawable.place_holder,
                title = "Home Renovation",
                id = "ABCDE21656",
                type = "Electrical",
                date = "31 Aug 2023"
            )
        )

        add(
            JobModel(
                image = R.drawable.place_holder,
                title = "Painting",
                id = "ABCDE21656",
                type = "Electrical",
                date = "31 Aug 2023"
            )
        )

        add(
            JobModel(
                image = R.drawable.place_holder,
                title = "Furniture Repair",
                id = "ABCDE21656",
                type = "Electrical",
                date = "31 Aug 2023"
            )
        )

        add(
            JobModel(
                image = R.drawable.place_holder,
                title = "Washing Machine Repair",
                id = "ABCDE21656",
                type = "Electrical",
                date = "31 Aug 2023"
            )
        )

        add(
            JobModel(
                image = R.drawable.place_holder,
                title = "Home Renovation",
                id = "ABCDE21656",
                type = "Electrical",
                date = "31 Aug 2023"
            )
        )

        add(
            JobModel(
                image = R.drawable.place_holder,
                title = "Painting",
                id = "ABCDE21656",
                type = "Electrical",
                date = "31 Aug 2023"
            )
        )

        add(
            JobModel(
                image = R.drawable.place_holder,
                title = "Furniture Repair",
                id = "ABCDE21656",
                type = "Electrical",
                date = "31 Aug 2023"
            )
        )
    }
}