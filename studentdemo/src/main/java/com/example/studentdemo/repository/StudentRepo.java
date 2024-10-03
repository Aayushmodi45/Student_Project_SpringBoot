    package com.example.studentdemo.repository;

    import com.example.studentdemo.model.Student;
    import jakarta.transaction.Transactional;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Modifying;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;

    import java.util.List;
    public interface StudentRepo extends JpaRepository<Student,Integer> {

        public Student findByMailAndPass(String mail,String pass);

        @Query("select mail from Student")
        public List<String> showAllMail();  // this is inbulit

        @Modifying
        @Transactional
        @Query("delete from Student s where s.mail=:mail")
        public void deleteByMail(@Param("mail")String mail);  // this method is created


        public Student findByMail(String mail);

        @Modifying
        @Transactional
        @Query("update Student s set s.name=:name,s.mail=:mail,s.pass=:pass,s.mobile=:mobile where s.sid=:sid")  //aliyass name is s
        public void updateMe(@Param("sid")int sid,@Param("name")String name,@Param("mail")String mail,@Param("pass")String pass,@Param("mobile")String mobile);
    }
