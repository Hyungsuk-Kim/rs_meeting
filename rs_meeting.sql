#create database richslide_meeting;
use richslide_meeting;

create table _user (
	user_id integer auto_increment comment'사용자 ID',
    user_name varchar(60) comment'사용자 이름',
    email varchar(60) null comment'사용자 이메일',
    password varchar(64) comment'비밀번호',
    role integer(1) comment'권한에 따른 사용자 분류코드',
    del_flag integer(1) comment'삭제 플래그',
    constraint user_pk primary key(user_id),
    constraint user_email_unique unique(email),
    check(role in(0, 1, 2))
) comment='시스템 사용자 정보 테이블';

create table _session (
	session_id integer auto_increment comment'세션 ID',
    subject varchar(2000) comment'브레인라이팅(세션)의 주제',
    master_id integer comment'세션 생성자 ID',
    start_time datetime comment'세션 시작 시간',
    end_time datetime comment'세션 종료 시간',
    time_per_round datetime comment'한 라운드 당 소요시간',
    suggestion_count integer(2) comment'',
    exposure integer(1) comment'세션의 공개 여부',
    del_flag integer(1) comment'삭제 플래그',
    constraint session_pk primary key(session_id),
    constraint session_fk foreign key(master_id) references _user(user_id) on update cascade,
    check (exposure in (0,1)),
    check (del_flag in (0,1))
) comment='브레인라이팅의 세션 정보 테이블';

create table _contributor (
	session_id integer comment'세션 ID',
    user_id integer comment'사용자 ID',
    constraint contributor_pk primary key(session_id, user_id),
    constraint contributor_fk_session_id foreign key(session_id) references _session(session_id) on update cascade,
    constraint contributor_fk_user_id foreign key(user_id) references _user(user_id) on update cascade
) comment='세션의 기여자(참여자) 정보 테이블';

create table _sheet (
	sheet_id varchar(10) comment'시트 ID',
    owner_id integer comment'시트 소유자 ID',
    session_id integer comment'해당(진행 중인) 세션 ID',
    constraint sheet_pk primary key(sheet_id),
    constraint sheet_fk_session_id foreign key(session_id) references _session(session_id) on update cascade,
    constraint sheet_fk_user_id foreign key(owner_id) references _user(user_id) on update cascade
) comment='아이디어를 기록하는 시트 정보 테이블';

create table _idea (
	idea_id integer auto_increment comment'아이디어 ID',
    sheet_id varchar(10) comment'해당 아이디어가 포함된 시트 ID',
    author_id integer comment'아이디어 작성자 ID',
    content varchar(2000) comment'아이디어 내용',
	constraint idea_pk primary key(idea_id),
    constraint idea_fk_author_id foreign key(author_id) references _user(user_id) on update cascade,
    constraint idea_fk_sheet_id foreign key(sheet_id) references _sheet(sheet_id) on update cascade
) comment='아이디어 정보 테이블';