require: slotfilling/slotFilling.sc
  module = sys.zb-common
require: functions.js
theme: /

    state: Start
        q!: $regex</start>
        #query 
        a: Молви друг и входи! {{getCurrentWeather("Tyumen")}}
        
        state: Melon || modal = true
            q: * (мелон|melon) *
            a: Вы вошли в подземелье Мории. Перед вами три коридора. 
               Какой выберете?
               
            state: Left
                q: * (*лев*|*перв*) *
                a: Gameover! Вас съел дракон. Желаете вернуться в начало?
                # как вернуть пользователя в начало?
                buttons:
                    "Да" -> /Start
                    "Нет" -> ./NoDeath
                    
                state: NoDeath
                    a: Ну окей, харакетр стойкий, нордический. Ты не умер.
                    go!: /Start
                
            state: Right
                q: * (*прав*|*трет*) *
                a: Перед вами сундук с сокровищами. Открываем?
                
                state: Open
                    q: * (да|~открывать) *
                    a: В сундуке вы видите золотые монеты.
                       Их ровно {{getRandomInt(100)}}.
                
            state: Middle
                q: * (*прям*|*средн*|*серед*|*втор*|*центр*|*перед*) *
                a: ...
                # Дописать сценарий
            
            #state: GoBack
            # Додумать сценарий.
            
            state: NoCatch
                event: noMatch
                a: Выбери направление.
            
        state: NoMelon || noContext = true
            event: noMatch
            a: На эльфийском друг!
            # go: Melon

    state: NoMatch
        event!: noMatch
        a: Скажите это по-эльфийски.