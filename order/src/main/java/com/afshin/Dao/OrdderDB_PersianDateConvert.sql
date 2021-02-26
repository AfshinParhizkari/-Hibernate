/*Change Miladi_date to Shamsi_date functions:
For example:
select *,concat(persian_year(paymentDate),'-',persian_month(paymentDate),'-',persian_day(paymentDate)) as Shamsi_paymentdate from payments
*/

CREATE FUNCTION `persian_mod`(a double,b double) RETURNS int(11)
    return (a - b * floor(a / b));

CREATE FUNCTION `persian_div`(a double,b double) RETURNS int(11)
    return (floor(a / b));

CREATE FUNCTION `persian_pj`(y int,m int,d int) RETURNS int(11)
    return ( 227260 +
             1029983 * persian_div((y - 474), 2820) +
             365 * ( (persian_mod((y - 474), 2820) + 474) - 1) +
             persian_div(682 * (persian_mod((y - 474), 2820) + 474) - 110, 2816) +
             if(m > 6, 30 * m + 6, 31 * m) + d );

DELIMITER $$
CREATE FUNCTION `persian_day`(indate date) RETURNS int(11)
begin
    declare j int(11);
    declare a int;
    declare b int ;
    declare c int;
    declare d int;
    declare yearr int;
    declare f double;
    declare monthh int;
    set j=TO_DAYS(indate) ;
    set a = j - persian_pj(475, 0, 1) ;
    set b = persian_div(a, 1029983) ;
    set c = persian_mod(a, 1029983) ;
    set d = if(c <> 1029982, persian_div(2816 * c + 1031337, 1028522), 2820) ;
    set yearr = 474 + 2820 * b + d;
    set f = (1 + j) - persian_pj(yearr, 0, 1);
    set monthh= if(f > 186, ceil((f - 6) / 30) - 1, ceil(f / 31) - 1);
    return (j - (persian_pj(yearr, monthh, 1) - 1));
END $$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION `persian_month`(indate date) RETURNS int(11)
begin
    declare j int;
    declare a int;
    declare b int ;
    declare c int;
    declare d int;
    declare yearr int;
    declare f double;
    set j=TO_DAYS(indate) ;
    set a = j - persian_pj(475, 0, 1) ;
    set b = persian_div(a, 1029983) ;
    set c = persian_mod(a, 1029983) ;
    set d = if(c <> 1029982, persian_div(2816 * c + 1031337, 1028522), 2820) ;
    set yearr = 474 + 2820 * b + d;
    set f = (1 + j) - persian_pj(yearr, 0, 1);
    return if(f > 186, ceil((f - 6) / 30) - 1, ceil(f / 31) - 1) +1;
end $$
DELIMITER ;

DELIMITER $$
CREATE FUNCTION `persian_year`(indate date) RETURNS int(11)
begin
    declare j int;
    declare a int;
    declare b int ;
    declare c int;
    declare d int;
    set j=TO_DAYS(indate) ;
    set a = j - persian_pj(475, 0, 1) ;
    set b = persian_div(a, 1029983) ;
    set c = persian_mod(a, 1029983) ;
    set d = if(c <> 1029982, persian_div(2816 * c + 1031337, 1028522), 2820) ;

    return 474 + 2820 * b + d;
end $$
DELIMITER ;