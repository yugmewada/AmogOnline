package com.example.composetutorial.provider

import com.example.composetutorial.data.CategoryModel
import com.example.composetutorial.data.HomeCategoriesModel

fun getHomeProductCategories(): MutableList<HomeCategoriesModel> {
    return mutableListOf<HomeCategoriesModel>().apply {
        add(
            HomeCategoriesModel(
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/customer/product_category/63aa93f5b1a531672099200.png",
                name = "Automobile, Bike & transportation"
            )
        )


        add(
            HomeCategoriesModel(
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/customer/product_category/640ed4fb4f9951678665600.png",
                name = "Health & Beauty"
            )
        )

        add(
            HomeCategoriesModel(
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/customer/product_category/640ed4d14b5f01678665600.png",
                name = "Clothing & Fashion"
            )
        )

        add(
            HomeCategoriesModel(
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/customer/product_category/640ed4b398f4d1678665600.png",
                name = "Tools & Heavy equipments"
            )
        )


        add(
            HomeCategoriesModel(
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/customer/product_category/640ed481b5e431678665600.png",
                name = "Property & accommodation"
            )
        )

        add(
            HomeCategoriesModel(
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/customer/product_category/648aacebc05bd1686787200.png",
                name = "Electronics & music/entertainment"
            )
        )


        add(
            HomeCategoriesModel(
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/customer/product_category/640ed4462dc531678665600.png",
                name = "Building & construction"
            )
        )

        add(
            HomeCategoriesModel(
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/customer/product_category/640ed42f008c01678665600.png",
                name = "Agency & Logistics Services"
            )
        )

        add(
            HomeCategoriesModel(
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/customer/product_category/640ed411a82e31678665600.png",
                name = "Food/ Agriculture & Animals"
            )
        )

        add(
            HomeCategoriesModel(
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/customer/product_category/63aa951194e191672099200.png",
                name = "Home & Office Materials"
            )
        )


        add(
            HomeCategoriesModel(
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/customer/product_category/640ed3da032fa1678665600.png",
                name = "Stationeries/magazines & printing Services"
            )
        )

        add(
            HomeCategoriesModel(
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/customer/product_category/640ed3bf4efe51678665600.png",
                name = "Supermarket & general Merchadise"
            )
        )


        add(
            HomeCategoriesModel(
                image = "https://hlik-deep-bhaumik.s3.amazonaws.com/amog/customer/product_category/640ed3a7a93fe1678665600.png",
                name = "Manufacturing & import/export"
            )
        )
    }
}


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