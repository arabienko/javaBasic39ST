INSERT INTO `users`(
    `id`,
	`login` ,
	`password` ,
	`role`
)VALUES(
    10,
    "student1" ,
    "509e87a6c45ee0a3c657bf946dd6dc43d7e5502143be195280f279002e70f7d9",
    2
),
(
    2,
    "student2" ,
    "eb4b3111401df980f14f28ad6804ae096df1e1c6963c51eab4140be226f8c94c",
     2
),
 (
     3,
     "teacher1" ,
     "d6a78e7024124b13ef172b5853e9c63943a618655af216be3cfa02b519eb8455",
     1
 ),
   (
       4,
       "teacher2" ,
       "1c8e87b3ef6a6cc33b5444feba8e25fa90ab8c7b09c3a7aef8e968d842b9add7",
       1
   ),
   (
       5,
       "student3" ,
       "373b29d2837e83b9ca5cec712a5985843df271cc7c06e64629472f4d03c6f83c",
       2
   ),
   (
        6,
        "teacher3" ,
        "e0e250fdab0d9bdd7257b4a3de352b1257cbcc9f863b647b9881771c53b532f2",
        1
   ),
   (
        7,
        "teacher4" ,
        "ff2333d547cb11168f28b001ef35b8ca28129c66f10039350c6210ce0a57740e",
         1
   ),
   (
         8,
         "teacher5" ,
         "9ed8068f69045e60c13fc55b509869578c6387d5443a9e52fbe1963bc44a1ec7",
         1
   ),
   (
        9,
        "teacher6" ,
        "8ce215d48de08a343e309e7c590ab6bc57e5d8a67d9d1f8d3638a50daaf07720",
        1
       ),
       (
       11,
       "student11" ,
       "dbc6629b707818ae64b268613a9ddd823f49db15310c0d66f3997b23a7b024ac",
       2
   ),
   (
       12,
       "student12" ,
       "fc08016060bfa59c19fe74987b26de306a921d78bc317c4120ffabc4bf92ac3c",
       2
   ),
   (
       13,
       "student13" ,
       "905233e5e2452dd86daa6e0ff4695ede8aaa95025fb0b4b1c78d12d62211d15f",
       2
   ),
   (
       14,
       "student14" ,
       "51ab7cb687ededf2cfa1c1f4fe426da8c21dafefb83e7a059070fc570ff1ce8f",
       2
   ),
   (
       15,
       "student15" ,
       "13cd6e3b1ad5f565c3bd992f3d7ddb5000babf3f4a66232b9b0a825ed688bc22",
       2
   );

INSERT INTO `students`(
    `id` ,
	`surname` ,
	`name` ,
	`phoneStudent`,
	`level`,
	`status`
) VALUES
    (5, "Ivanov", "Ivan", "+37291112233","start", "confirm"),
    (2, "Semenov", "Semen", "+375293332211","medium", "confirm"),
    (3, "Petrov", "Petr", "+375294443322","advance", "wait"),
    (4, "Arabiyenka", "Tatsiana", "+375293332222","medium", "wait");


INSERT INTO `subjects` (
     `id` ,
     `nameSubject`
) VALUES
    (1,     "mathematics"),
    (2,     "english"),
    (3,     "physics"),
    (4,     "chemistry");

    INSERT INTO `teachers`(
	`id` ,
	`surname` ,
	`name` ,
	`idSubject` ,
	`phoneTeacher`,
	`degree`,
	`pathImage`
) VALUES
    (1,     "Lozkina",      "Lozka",    1,  "+375441112233",    "bachelor", "url1"),
    (2,     "Iovina",       "Olga",     2,  "+375334567899",    "master", NULL),
    (3,     "Kalinina",     "Veronika", 3,  "+375295554466",    "doctor", "url2"),
    (4,     "Trophimova",   "Olga",     1,  "+375336669988",    NULL, "url3"),
    (5,     "Eremina",      "Tatsiana", 4,  "+375442213223",    NULL, NULL),
    (6,     "Chernic",      "Svetlana", 3,  "+375298889977",    "master", "url4");

    INSERT INTO `schedule_subjects`(
    `id` ,
    `data_time` ,
    `idTeacher`
)VALUES
    (1,     "2022-04-05 12-30-00",    2),
    (2,     "2022-04-05 12-00-00",    1),
    (3,     "2022-04-08 10-30-00",    2),
    (4,     "2022-04-10 11-30-00",    3),
    (5,     "2022-04-12 15-30-00",    4),
    (6,     "2022-04-05 18-00-00",    5),
    (7,     "2022-04-05 16-30-00",    6),
    (8,     "2022-04-14 08-30-00",    6);

    INSERT INTO `record_students`(
    `id` ,
    `idSchedule` ,
    `idStudent`
) VALUES
    (1,     1,      5),
    (2,     2,      2),
    (3,     3,      3),
    (5,     5,      4),
    (6,     6,      4),
    (8,     8,      2);