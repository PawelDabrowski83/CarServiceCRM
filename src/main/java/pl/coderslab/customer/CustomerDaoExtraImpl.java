//package pl.coderslab.customer;
//
//import pl.coderslab.commons.DbUtil;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashSet;
//import java.util.Set;
//
//public class CustomerDaoExtraImpl implements CustomerDaoInterface<CustomerEntity> {
//
//    @Override
//    public Set<CustomerEntity> findUnmatched() {
//        try (Connection conn = DbUtil.getConnection()) {
//            PreparedStatement statement = conn.prepareStatement(FIND_UNMATCHED_PERSON);
//            ResultSet resultSet = statement.executeQuery();
//            Set<CustomerEntity> entities = new HashSet<>();
//            while (resultSet.next()) {
//                entities.add(getEntityFromResultSet(resultSet));
//            }
//            return entities;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return new HashSet<>();
//    }
//}
