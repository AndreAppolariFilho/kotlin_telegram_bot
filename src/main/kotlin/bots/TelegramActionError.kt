package bots

import com.vdurmont.emoji.EmojiParser
import org.telegram.telegrambots.meta.api.methods.send.SendMessage

class TelegramActionError: ITelegramAction {
    override fun execute(bot: KotlinBot, chatId:String) {
        val sendDocument = SendMessage().apply {
            this.chatId = chatId
            this.text = EmojiParser.parseToUnicode("não funcionou :disappointed:")
            this.parseMode = "MarkdownV2"
        }

        bot.execute(sendDocument)
    }
}