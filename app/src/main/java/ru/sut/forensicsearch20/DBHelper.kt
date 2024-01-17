package ru.sut.forensicsearch20

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        val COLUMN_INFO: String? = null
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "MyDatabase.db"

        const val TABLE_NAME = "forensic_table"
        const val COL_ID = "id"
        const val COL_NAME = "program_name"
        const val COL_INFO = "information"
        const val COL_TG = "target_OS"
        const val COL_BG = "base_OS"
        const val COL_PRICE = "price"

        const val COL_S_AREA = "search_area"
        const val COL_BG_Win = "base_OS_win"
        const val COL_BG_Lin = "base_OS_lin"
        const val COL_BG_Mac = "base_OS_mac"
        const val COL_TG_Win = "target_OS_win"
        const val COL_TG_Lin = "target_OS_lin"
        const val COL_TG_Mac = "target_OS_mac"
        const val COL_TG_And = "target_OS_and"
        const val COL_TG_IOS = "target_OS_ios"
        const val COL_A_Net = "search_area_net"
        const val COL_A_Sea = "search_area_sea"
        const val COL_A_Rec = "search_area_rec"
        const val COL_A_Bre = "search_area_bre"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableStatement = "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_NAME TEXT, $COL_INFO TEXT, $COL_TG TEXT, $COL_BG TEXT, $COL_PRICE TEXT, $COL_S_AREA TEXT, $COL_BG_Win INTEGER, $COL_BG_Lin INTEGER, $COL_BG_Mac INTEGER, $COL_TG_Win INTEGER, $COL_TG_Lin INTEGER, $COL_TG_Mac INTEGER, $COL_TG_And INTEGER, $COL_TG_IOS INTEGER, $COL_A_Net INTEGER, $COL_A_Sea INTEGER, $COL_A_Rec INTEGER, $COL_A_Bre INTEGER)"
        println(createTableStatement)
        db.execSQL(createTableStatement)
        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('Elcomsoft iOS Forensic Toolkit','Функциональность:\n" +
                "•\tРасширенная информация об устройстве\n" +
                "•\tЛогическое извлечение (резервная копия)\n" +
                "•\tИзвлечение медиафайлов и метаданных\n" +
                "•\tИзвлечение диагностических логов\n" +
                "•\tИзвлечение агентом с учётной записью разработчика\n" +
                "•\tИзвлечение агентом с обычной учётной записью\n" +
                "•\tИзвлечение через уязвимости загрузчика\n','Все поколения iPhone, iPad и iPod Touch; Apple TV; Apple Watch; HomePod (первого поколения); связка ключей; образ файловой системы; iOS 3 - iOS 17; работа через режим загрузчика; работа через агент-экстрактор','Windows 7/8/8.1/10/11\n" +
                "Apple macOS " +
                "10.13-14\n" +
                "Linux (Mint, Debian, Kali, Ubuntu)\n','139000','Извлечение данных, Обход блокировок паролями',1,1,1,0,0,1,0,0,0,1,0,1)")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('Elcomsoft Mobile Forensic Bundle','Функциональность:\n" +
                "•\tФизический анализ устройств iOS\n" +
                "•\tЛогическое извлечение данных из заблокированных устройств\n" +
                "•\tИзвлечение данных из облака iCloud\n" +
                "•\tВосстановление паролей к зашифрованным резервным копиям iTunes\n" +
                "•\tПоддержка Windows Phone, Windows 10 Mobile и BlackBerry 10\n" +
                "•\tАнализ данных, собранных Google\n" +
                "•\tИзвлечение и расшифровка истории переписки WhatsApp','Все поколения устройств под управлением iOS (iPhone, iPad и iPod Touch); расшифровка резервных копий BlackBerry OS и BlackBerry 10; дистанционное извлечение данных из учётных записей Google и Microsoft; история коммуникаций WhatsApp (iOS, Android).','Windows 7/8/8.1/10/11\n" +
                "Apple macOS " +
                "10.13-12\n','229000','Извлечение данных, Обход блокировок паролями',1,1,0,0,0,1,1,0,0,1,0,1)")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('Elcomsoft Desktop Forensic Bundle','Функциональность: \n" +
                "Cнятие парольной защиты с файлов, извлечение паролей из почтовых клиентов и браузеров.','Системы на базе Windows или MacOS','Windows 2000/98/XP/Vista/7/8/8.1/10/11/Server 2003,2008,2012','189000','Извлечение данных, Обход блокировок паролями, Восстановление данных',1,0,0,1,1,0,0,0,0,1,1,1)")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('Elcomsoft Premium Forensic Bundle','Функциональность: \n" +
                "Аналогична утилитам iOS Forensic Toolkit, Mobile Forensic Bundle, Desktop Forensic Bundle от Elcomsoft.','Windows/macOS/IOS/BlackberryOS','Windows 7/8/8.1/10/11\n" +
                "Apple MacOS 10.13-14\n" +
                "Linux (Mint, Debian, Kali, Ubuntu)\n" +
                "Прим. Зависит от функционала','448500','Извлечение данных, Обход блокировок паролями, Восстановление данных',1,1,1,1,1,1,1,0,0,1,1,1)")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('ReclaiMe','Функциональность: \n" +
                "Чтение и восстановление служебных и пользовательских данных с файловых систем NTFS, FAT, exFAT, ext2/3/4.','Windows/Linux/macOS','Windows 7/8/8.1/10/11','29145','Извлечение данных, Восстановление данных',1,0,0,1,1,0,0,1,0,1,1,0)")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('PC-3000','Функциональность:\n" +
                "Программно-аппаратный комплекс по восстановлению данных с жестких дисков или SSD. Совместно с Data Extractor позволяет извлечь данные из неисправных жестких дисков.Функциональность:программно-аппаратный комплекс по восстановлению данных с жестких дисков или SSD. Совместно с Data Extractor позволяет извлечь данные из неисправных жестких дисков.','FAT, exFAT, NTFS, EXT2/3/4, HFS+, UFS1/2, XFS, ReiserFS, VMFS, APFS, WFS0.4, DHFS4.1/ VMDK (VMWare), VHD, VHDX, DMG.','Windows 7/8/8.1/10/11','140100','Извлечение данных, Восстановление данных',1,0,0,1,0,0,0,1,0,1,1,0)")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('PC-3000 Mobile','Функциональность: \n" +
                "Программно-аппаратный комплекс по восстановлению данных с eMMC/SD накопителей, анализ файловой системы и извлечение данных из приложений Android.','Android','Windows 7/8/8.1/10/11','По запросу','Извлечение данных, Восстановление данных',1,0,0,0,0,0,1,0,0,1,1,0)")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('TERRIER 3.0','Функциональность:\n" +
                "•\tвыбор диска для поиска ключевых слов;\n" +
                "•\tпросмотр содержимого текущего диска;\n" +
                "•\tпросмотр параметров текущего диска;\n" +
                "•\tсохранение фрагмента текущего диска в файл;\n" +
                "•\tкопирование фрагмента текущего диска в буфер обмена;\n" +
                "•\tпечать фрагмента текущего диска на принтере;\n" +
                "•\tсохранение образа текущего диска в файл;\n" +
                "•\tподключение образа диска, сохраненного в файл;\n" +
                "•\tформирование списков ключевых слов;\n" +
                "•\tвыбор параметров поиска ключевых слов;\n" +
                "•\tпоиск ключевых слов на диске;\n" +
                "•\tвыборочное гарантированное уничтожение найденных ключевых слов;\n" +
                "•\tформирование отчета по результатам поиска;\n" +
                "•\tпоиск файла, содержащего найденное ключевое слово;\n" +
                "•\tпросмотр журнала событий программы;\n" +
                "•\tпросмотр параметров лицензии программы.\n" +
                "Определение имени и расположение файла, содержащего найденное ключевое слово, осуществляется для файловых систем Fat (Fat12, Fat16, Fat32) и NTFS.\n','Fat (Fat12, Fat16, Fat32), NTFS','Windows XP/Vista/7/8/8.1/10/11','По запросу','Извлечение данных, Восстановление данных',1,0,0,0,0,0,0,1,0,1,1,0)")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('Гарда Монитор','Функциональность:\n" +
                "•\tЗапись сетевого трафика в исходном виде\n" +
                "•\tГибкий поиск по свойствам, выделенным из записанных потоков информации (IP-адреса, порты, mac-адерса, email, учетные записи, страна отравителя/получателя, протокол и пр.)\n" +
                "•\tКлассификация трафика по протоколам (НТТР, POPЗ, FTP,SSH и ещё свыше 250 типов протоколов)\n" +
                "•\tВозможность  добавить пользовательские протоколы\n" +
                "•\tВозможность выгрузки содержимого интересующей сессии в формате PCAP \n" +
                "•\tПостроение графических отчётов по найденным массивам информации\n" +
                "•\tВозможность задать срок хранения статистики и трафика (например, статистику храним в течение 1 месяца, а содержимое – 3 дня)\n" +
                "•\tВозможность указать правила записи трафика (например, для шифрованных потоков сохраняем только статистику)\n" +
                "•\tОпределение географического положения источника и получателя данных\n" +
                "•\tИнтеграция с SIEM системами\n" +
                "•\tВыявление фактов сетевой разведки и атак на узлы сети с помощью сигнатурных решающих правил\n" +
                "•\tВыявление обращений к скомпрометированным ресурсам на основе принадлежности к репутационным спискам\n" +
                "•\tВыявление аномального поведения устройств и пользователей\n" +
                "•\tВозможность просмотра истории авторизации пользователей на рабочих станциях\n" +
                "•\tАвтоматически обновляемые решающие правила\n" +
                "•\tАвтоматически обновляемые базы репутационных списков (скомпрометированные IP-адреса, email, url)\n" +
                "•\tАвтоматически обновляемая база определения географического положения IP-адресов\n" +
                "•\tАвтоматическое выявление инцидентов информационной безопасности\n" +
                "•\tНастройка автоматического уведомления об инцидентах сотрудника ИБ\n" +
                "•\tЕдиный центр управления для контроля всех участков сети (в т.ч. и распределённой), детектирования атак и оперативного реагирования на киберугрозы\n','Сетевая инфраструктура','Linux','По запросу','Сетевая криминалистика',0,0,1,0,0,0,0,0,0,0,0,1)")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('Мобильный Криминалист Enterprise','Функциональность:\n" +
                "•\tДистанционный централизованный сбор данных с рабочих станций и серверов при помощи Агентов.\n" +
                "•\tПоиск по задаваемым пользователем правилам YARA\n" +
                "•\tИсследование подключенных внешних дисков, физических образов E01/Ex01, RAW (DD/BIN/ IMG), DMG, ISO, логических образов L01/Lx01, AD1, архивов ZIP, 7Z, RAR, TAR.\n" +
                "•\tИсследование образов Apple-устройств, созданных с помощью Time Machine.\n" +
                "•\tИсследование образов виртуальных машин VMX, VBOX, а также образов жестких дисков виртуальных машин VDI, VHD, VMDK.\n" +
                "•\tСбор подробной информации о событиях на исследуемой рабочей станции благодаря детальному анализу артефактов систем на Windows, macOS и GNU/Linux.\n" +
                "•\tИзвлечение информации из файловых служб: Amazon S3, Mega, Microsoft SharePoint, iCloud Backup и т.д.\n" +
                "•\tИзвлечение информации из мессенджеров: Chatwork, Flock, Line, Slack, Telegram, WhatsApp, Zoom и т.д.\n" +
                "•\tИзвлечение информации из почтовых агентов: Gmail, Mail.ru, Microsoft Outlook, Yandex.Mail\n" +
                "•\tИзвлечение информации из социальных сетей: Facebook, Instagram, Linkedin, ВКонтакте и т.д.\n" +
                "•\tВыявление прямых и косвенных связей между \n" +
                "•\tконтактами одного или нескольких извлечений.\n" +
                "•\tПоиск по различным параметрам: номерам телефонов, контактам, ключевым словам, метаданным, содержимому файлов и др.\n" +
                "•\tПостроение всех событий исследуемого устройства в хронологическом порядке.\n" +
                "•\tИзвлечение и расшифровка данных из устройств от Apple, Samsung, Huawei, Xiaomi, Realme, Oppo, Sony, LG и др.\n" +
                "•\tОбход или подбор паролей на блокировку экрана исследуемого устройства.\n" +
                "•\tПолучение информации из установленных на смартфоне приложений: Brave Private Browser, ExpressVPN, Gmail, Google Meet, ProtonMail, Signal, Skype, Spark, TeamViewer, TenChat, WhatsApp, Zoom и др.','Windows/Linux/macOS/IOS/Android','Windows XP/Vista/7/8/8.1/10/11','По запросу','Извлечение данных, обход блокировок паролями, восстановление данных, анализ данных. Решение полного цикла',1,0,0,1,1,1,1,1,1,1,1,0)")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('Мобильный Криминалист Эксперт Плюс','Функциональность:\n" +
                "•\tИзвлекает полную файловую структуру и данные Keychainиз iOS-устройств.\n" +
                "•\tСоздает физические образы устройств под управлением Android, Kai и др.\n" +
                "•\tСоздает логические образы устройств под управлением iOS, Android, BlackBerry, Windows Phone, Symbian и др.\n" +
                "•\tИзвлекает расшифрованные данные из Android-устройств с пофайловым и полнодисковым шифрованием.\n" +
                "•\tИмпортирует физические образы и резервные копии множества устройств.\n" +
                "•\tПолучает данные из дронов и выстраивает маршруты полетов.\n" +
                "•\tИзвлекает информацию из нескольких десятков облачных сервисов: Apple, Google, Yandex, WhatsApp, Viber, Telegram и др.\n" +
                "•\tИсследует запущенные системы на Windows, macOS, GNU/Linux, подключенные внешние диски, а также логические образы ПК в форматах ZIP, AD1, RAR и др.\n" +
                "•\tПолучает подробную информацию о событиях на целевой машине благодаря детальному анализу артефактов систем на Windows, macOS и GNU/Linux\n" +
                "•\tПолучает письма и контакты из почтовых агентов Mozilla Thunderbird, Microsoft Outlook, Microsoft Mail.\n" +
                "\n','Windows/Linux/macOS/IOS/Android','Windows XP/Vista/7/8/8.1/10/11','По запросу','Извлечение данных, обход блокировок паролями, восстановление данных, анализ данных. Решение полного цикла',1,0,0,1,1,1,1,1,1,1,1,0)")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('Мобильный Криминалист Эксперт','Функциональность:\n" +
                "Аналогична Мобильный Криминалист Эксперт Плюс, за исключением лицензионных ограничений','Windows/Linux/macOS/IOS/Android','Windows XP/Vista/7/8/8.1/10/11','По запросу','Извлечение данных, обход блокировок паролями, восстановление данных, анализ данных. Решение полного цикла',1,0,0,1,1,1,1,1,1,1,1,0)")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('Аналитический Центр Криминалист','Функциональность:\n" +
                "•\tРабота с контактами, аккаунтами, групповыми чатами и их коммуникациями.\n" +
                "•\tАнализ фото, аудио- и видеофайлов из извлечений.\n" +
                "•\tУстановление связей между устройствами, делами и группами дел.\n" +
                "•\tПоиск упоминаний в данных номеров телефонов, email, URL, номеров банковских карт, IP-адресов, MAC-адресов.\n" +
                "•\tПоиск по тематическим словарям\n" +
                "•\tФормирование гипотезы о составе преступления с помощью функционала «Текстовый анализатор».\n" +
                "•\tПоиск и работа с геометками на карте.\n" +
                "•\tИмпорт и анализ данных из .pst контейнеров, образов ПК, ноутбуков, рабочих станций, серверов и облачных сервисов.\n" +
                "•\tПрямая загрузка данных в «Аналитический Центр» в форматах OFBX, OFBR, ODB.\n" +
                "•\tПоиск по данным коммуникаций из мессенджеров, приложений и почтовых клиентов.\n" +
                "•\tПроведение глобального поиска по email, номеру телефона, id аккаунта.\n" +
                "•\tПоиск по подстроке, регулярному выражению, словарю в содержимом документов и распознанном тексте с фотографий или картинок.\n" +
                "•\tВозможность устанавливать пользовательские теги к загруженным данным.\n" +
                "•\tИнтеграция с продуктами линейки «Мобильный криминалист»\n','Windows/Linux/macOS/IOS/Android','Linux/Windows (клиент-серверное решение)','По запросу','Извлечение данных, обход блокировок паролями, восстановление данных, анализ данных. Решение полного цикла',1,0,0,1,1,1,1,1,1,1,1,0)")

        db.execSQL("INSERT INTO $TABLE_NAME ($COL_NAME,$COL_INFO,$COL_TG,$COL_BG,$COL_PRICE,$COL_S_AREA,$COL_BG_Win,$COL_BG_Lin,$COL_BG_Mac,$COL_TG_Win,$COL_TG_Lin,$COL_TG_Mac,$COL_TG_And,$COL_TG_IOS,$COL_A_Net,$COL_A_Sea,$COL_A_Rec,$COL_A_Bre) VALUES ('Мобильный Криминалист Десктоп','Функциональность:\n" +
                "•\tизвлечение массива криминалистически важных данных за короткое время (учетные данные, токены, переписка, контакты, вложения и многое другое);\n" +
                "•\tпроведение первичной экспертизы данных персональных компьютеров;\n" +
                "•\tбыстрый анализ полученной информации;\n" +
                "•\tформирование общего представления о данных на компьютере и портрета его владельца;\n" +
                "•\tобнаружение кражи интеллектуальной собственности;\n" +
                "•\tраскрытие инсайдерства;\n" +
                "•\tвысокоскоростной анализ данных из нескольких устройств;\n" +
                "•\tустановление каналов утечки конфиденциальных данных;\n" +
                "•\tвыявление нецелевого использования рабочего времени.\n" +
                "•\tИзвлечение следующих данных из АРМ:\n" +
                "••\tсообщения, контакты, файлы вложений из мессенджеров Viber, Unigram, Wickr Me, Skype и др.;\n" +
                "••\tписьма и контакты из почтовых агентов Mozilla Thunderbird, Microsoft Outlook, Microsoft Mail и др.\n" +
                "••\tлогины/пароли и токены приложений Viber for Desktop, Unigram X, Wickr Me Desktop, Skype for Desktop, WhatsApp Desktop, Telegram, TamTam Desktop, iCloud for Windows, Mozilla Thunderbird, Microsoft Outlook;\n" +
                "••\tданные из веб-браузеров Google Chrome, Safari, Mozilla Firefox, Opera, Microsoft Edge, Internet Explorer: история посещения, поиска и загрузок, закладки, данные форм автозаполнения, учетные данные и cookies;\n" +
                "••\tданные стандартных приложений Apple: Apple Messages, Apple Photos, Apple Notes, Apple Reminders, Apple Contacts, Apple Mail, Apple Calendar, Apple Maps;\n" +
                "••\tданные системных артефактов: Shellbags, Jump Lists, USBSTOR, файлов реестра (AmCache, SAM, SOFTWARE), ActivitiesCache, Prefetch-файлы, KnowledgeC, QuarantineEventsV2, FSEvents и др.\n" +
                "••\tданные секретных хранилищ Keychain и Windows Vault;\n" +
                "••\tсписок Wi-Fi точек доступа и пароли к ним;\n" +
                "••\tинформацию о системе ПК;\n" +
                "••\tданные о действиях пользователя на компьютере;\n" +
                "••\tисторию действий с файлами и документами;\n" +
                "••\tсведения о всех подключениях к компьютеру через USB-порт;\n" +
                "••\tрезервные копии iTunes.','Windows','Windows XP/Vista/7/8/8.1/10/11','По запросу','Извлечение данных, обход блокировок паролями, восстановление данных, анализ данных. Решение полного цикла',1,0,0,1,0,0,0,0,1,1,1,0)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addInformation(info: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COL_INFO, info)
        }
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getInformation(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }
}