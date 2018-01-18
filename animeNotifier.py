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
        return self.name + " at " + str(self.hour) + ":" + str(self.minute) + " on " +self.platform

    def hasBeenAired(self) :
        now = datetime.datetime.now()

    def willBeAiredToday(self) :
        now = datetime.datetime.now()
        date = datetime.date(now.year,now.month,now.day)
        #print(self.name,date.weekday,self.day)
        if(date.weekday() == self.day) :
            return True
        else :
            return False

def initAnime() :
    animes.append(Anime("Minuscule",4,14,30,"wakanim"))
    animes.append(Anime("Sangatsu no lion 2",5,17,40,"wakanim"))
    animes.append(Anime("Mitsuboshi colors",6,15,30,"wakanim"))
    animes.append(Anime("Dagashi kashi 2",5,15,0,"adn"))
    animes.append(Anime("Karakai jozu no takagi-kun",0,17,30,"crunchyroll"))
    animes.append(Anime("Yowamushi pedal 4",0,21,5,"crunchyroll"))
    animes.append(Anime("A place further in the universe",1,14,30,"crunchyroll"))
    animes.append(Anime("Laid-back camp",3,16,30,"crunchyroll"))
    animes.append(Anime("Citrus",5,15,0,"crunchyroll"))
    animes.append(Anime("Darling in the franxx",5,18,0,"crunchyroll"))
    animes.append(Anime("The ancient magus bride",5,19,30,"crunchyroll"))
    animes.append(Anime("Violet evergarden",3,14,30,"netflix")) #approx time
    animes.append(Anime("After rain",3,19,40,"amazon")) #approx time

def main() :
    initAnime()
    while(True) :
        now = datetime.datetime.now()
        print(now.day,now.hour,now.minute)
        for anime in animes :
            if anime.willBeAiredToday() :
                print(anime)
                os.system("notify-send \"" + str(anime) + "\"")
        time.sleep(60*5)
    #date = datetime.date(now.year,now.month,now.day)
    #print(date.weekday())

if __name__ == '__main__':
    main()
