package bots


interface ITelegramAction {
    fun execute(bot: KotlinBot, chatId:String)
}