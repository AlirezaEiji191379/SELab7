replace-conditional-with-polymorphism: 
تو این قسمت کاری که انجام شد این بود که کلاس code generator یک تعداد زیادی switch case در شرط هایش داشت و این باعث میشد که اصل ocp رعایت نشود.
هر عملی در یک کلاس مجزا تعریف شد و از الگوی طراحی strategy استفاده شد.

در پکیج codeGenerator در فایل function پیاده سازی همه عملگرها موجود است

در پکیج factory نیز برای ساخت هر کدام از کلاس های عملگر برحسب نوع عدد ورودی برای function استفاده شد.

کلاس codeGeneratoor ریفکتور شد و آن تابع بزرگ با پیاده سازی های مختلف چند ریختی درست شد.



Facade 1:

در کلاس Parser کلاس های دیگر مثل ParseTable و LexicalAnalyser و CodeGenerator بیرون کشیده شدند و در یک
کلاس Facade قرار گرفته و Wrapp شدند.

Facade 2:
کلاس هایی مموری و symbobTable ازشان interface بیرون کشیده شد و تمامی توابع آن ها در یک کلاس به نام SemanticFacade جمع شد که در کلاس های CodeGnerator استفاده میشود.


Seprate Query from modifier:

در کلاس مموری تابع getTemp به دو تابع getTemp  و updateLastTempIndex شکسته شد و متد کوئری از متد تغییر دهنده جدا شد.

Self encapsulated field:

در کلاس Memory فیلد privateی به نام codeBlock برایش یک تابع getter نوشته شد و از همان در کلاس استفاده شد.

Extract Method:

در کلاس ParseTable تابع سازنده به یک تابع دیگر به نام Init شکسته شد سپس خود تابع init نیز به دو تابع initTables و setTerminalsAndCols شکسته شدند.

Replace Temp With Query:

در کلاس Memoty دو تابع جدید به نام Temp و DateAddress ساخته شد که در توابع دیگر استفاده میشوند و مطابق الگو بازآرایی شده اند.

