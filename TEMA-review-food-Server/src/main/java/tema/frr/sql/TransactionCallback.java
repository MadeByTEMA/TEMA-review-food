package tema.frr.sql;

public interface TransactionCallback {
  Object doInTransaction() throws Exception;
}
