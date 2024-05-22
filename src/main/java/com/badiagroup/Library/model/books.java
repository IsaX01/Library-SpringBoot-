@Entity
public class Books {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private Date release_date;
    private String genre;
    private String language;
    private Interger qty;
    private String status;
    // getters y setters
}