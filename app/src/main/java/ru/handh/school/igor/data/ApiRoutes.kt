package ru.handh.school.igor.data

object ApiRoutes {
    private const val BASE_URL = "http://45.144.64.179/swagger/"

    const val SIGNIN = "$BASE_URL/project/api/auth/signin"

    const val REFRESH = "$BASE_URL/project/api/auth/refresh"

    const val SIGNOUT = "$BASE_URL/project/api/auth/signout"

    const val PROFILE = "$BASE_URL/project/api/account/profile"

    const val PROJECTS = "$BASE_URL/project/api/projects"

    const val NOTIFICATION = "$BASE_URL/project/api/notifications"
}