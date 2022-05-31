package a06367.apicture.alertDialog

interface DialogListener {
    fun onYesClicked(obj: Any?)
    fun onNoClicked(error: String?)
}