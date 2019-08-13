package dev.petronilio.githubapp.repository

import dev.petronilio.githubapp.api.GithubService
import dev.petronilio.githubapp.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepositoryImpl(val service: GithubService) : UserRepository{
    override fun search(user: String, onComplete: (User?) -> Unit, onError: (Throwable?) -> Unit) {
        service.findUser(user)
            .enqueue(object: Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                   onError(t)
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful){
                      onComplete(response.body())
                    }else{
                        onError(Throwable("Não foi possível realizar a busca"))
                    }
                }
            })
    }
}