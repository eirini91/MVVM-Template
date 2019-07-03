package com.pkfcooperparry.template.data.model.api.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.pkfcooperparry.template.data.model.db.User


class UserRequest(@field:Expose
                  @field:SerializedName("user")
                  var user: User?)
