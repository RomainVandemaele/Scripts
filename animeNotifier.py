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
    animes.append(Anime("Encouragement of climb 3",0,21,00,"crunchyroll"))

    animes.append(Anime("Angels of death",4,15,00,"crunchyroll"))
    animes.append(Anime("Harukana receive",4,15,30,"crunchyroll"))
    animes.append(Anime("Chio's school road",4,16,30,"crunchyroll"))

    animes.append(Anime("My hero academia",5,11,30,"crunchyroll"))
    animes.append(Anime("Les brigades immunitaires",5,18,30,"crunchyroll"))

    animes.append(Anime("Asobi asobase",6,15,30,"crunchyroll"))
    animes.append(Anime("Island",6,16,30,"crunchyroll"))
    animes.append(Anime("Hanabado",6,18,0,"crunchyroll"))

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
