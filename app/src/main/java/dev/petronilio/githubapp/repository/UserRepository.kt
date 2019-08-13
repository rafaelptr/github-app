package dev.petronilio.githubapp.repository

import dev.petronilio.githubapp.model.User

interface UserRepository {

    fun search(
        user: String,
        onComplete: (User?) -> Unit,
        onError: (Throwable?) -> Unit
    )
}
