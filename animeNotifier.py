import datetime
import os
import time



animes = []
days = ["monday","tuesday","wednesday","thursday","friday","saturday","sunday"]

class Anime :
    def __init__(self,name,day,hour,minute,platform) :
        self.name = name
        self.day = day
        self.hour = hour
        self.minute = minute
        self.platform = platform

    def __str__(self) :
        minute = str(self.minute)
        if (self.minute < 10) :
            minute = "0" + minute
        return self.name + " at " + str(self.hour) + ":" + minute + " on " +self.platform

    def hasBeenAired(self) :
        now = datetime.datetime.now()
        date = datetime.date(now.year,now.month,now.day)
        #print(self.name,now.hour,now.minute)
        if(date.weekday() == self.day and ( (self.hour == now.hour and self.minute <= now.minute) or (self.hour < now.hour ) ) ) :
            return True
        else :
            return False

    def willBeAiredToday(self) :
        now = datetime.datetime.now()
        date = datetime.date(now.year,now.month,now.day)
        #print(self.name,date.weekday,self.day)
        if(date.weekday() == self.day) :
            return True
        else :
            return False

def initAnime() :
    animes.append(Anime("Magical girl ore",0,16,00,"crunchyroll"))
    animes.append(Anime("Golden kamui",0,18,30,"crunchyroll"))
    animes.append(Anime("Yowamushi pedal 4",0,21,5,"crunchyroll"))

    animes.append(Anime("Steins gate 0",2,19,30,"wakanim"))

    animes.append(Anime("Hinamatsuri",4,15,30,"crunchyroll"))

    animes.append(Anime("My hero academia",5,11,30,"ADN"))
    animes.append(Anime("Amanchu advance",5,17,0,"crunchyroll"))
    animes.append(Anime("Darling in the franxx",5,18,0,"crunchyroll"))


    animes.append(Anime("Gegege no kitaro",6,8,30,"crunchyroll"))
    animes.append(Anime("Shokugeki no soma",6,18,30,"crunchyroll"))

def main() :
    initAnime()
    notif1 = [False for i in range(len(animes))]
    notif2 = [False for i in range(len(animes))]
    while(True) :
        now = datetime.datetime.now()
        #print(now.day,now.hour,now.minute)
        for anime in animes :
            index = animes.index(anime)

            if now.hour >= 10 and anime.willBeAiredToday() and notif2[index] == False : #when available today
                os.system("notify-send \"" + str(anime) + "\"")
                notif2[index] = True

            if now.hour >= 10 and anime.hasBeenAired() and notif1[index] == False : #when available now
                os.system("notify-send \"" + anime.name + " is available now on " + anime.platform + "\"")
                notif1[index] = True

        time.sleep(60*5)
        if( now.hour == 1) : #reset
            notif1 = [False for i in range(len(animes))]
            notif2 = [False for i in range(len(animes))]
    #date = datetime.date(now.year,now.month,now.day)
    #print(date.weekday())

if __name__ == '__main__':
    main()
