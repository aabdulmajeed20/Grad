function () {
 document.getElementById("IDToken1").value = "Some random text";
 document.bgColor = "#333";
}
//val jsContent: String?
//        jsContent = try {
//            val inputStream = assets.open("test.js")
//            val fileContent = inputStream.bufferedReader().use(BufferedReader::readText)
//            inputStream.close()
//            fileContent
//        } catch (e: Exception) {
//            null
//        }
//        jsContent?.let { web_view.loadUrl("javascript:($jsContent)()") }