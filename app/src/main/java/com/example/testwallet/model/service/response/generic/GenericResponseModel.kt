package com.example.com.example.testwallet.data.model.service.response.generic

import com.example.com.example.testwallet.data.model.service.response.generic.errorhandling.ErrorHandlingModel
import com.example.com.example.testwallet.data.model.service.response.generic.popup.PopupModel

data class GenericResponseModel(
    var responseData: Any,
    var hasPopup: Boolean,
    var popUp: PopupModel,
    var hasError: Boolean,
    var errorHandling: ErrorHandlingModel
)