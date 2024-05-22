@Entity
public class Loans {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Interger user_id;
    private Interger book_id;
    private Date load_date;
    private Date return_date;
    private Date real_return_date;
    private String status;
    // getters y setters
}