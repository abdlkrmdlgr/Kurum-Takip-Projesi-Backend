package com.restDeneme.resDeneme.util;

import com.restDeneme.resDeneme.model.Kurum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class KurumDAO extends DataAccessObject<Kurum> {

    private static final String INSERT=
            "INSERT into customer(owner,kurumAdi,logo) VALUES(?,?,?)";

    private static final String GET_ONE="SELECT id,owner,kurumAdi,logo FROM customer" +
            " WHERE id=?";

    private static final String UPDATE = "UPDATE customer SET owner = ?, kurumAdi=?, " +
            "logo = ? WHERE customer_id = ?";

    private static final String DELETE="DELETE FROM customer WHERE id=?";

    public KurumDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Kurum findById(long id) {
        Kurum customer=new Kurum();
        try(PreparedStatement preparedStatement=this.connection.prepareStatement(GET_ONE);){

            preparedStatement.setLong(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                customer.setId(resultSet.getLong("customer_id"));
                customer.setKurumAdi(resultSet.getString("first_name"));
                customer.setOwner(resultSet.getString("last_name"));
                customer.setLogo(resultSet.getString("email"));
            }


        }catch (SQLException e){
            e.printStackTrace();
            throw  new RuntimeException(e);

        }
        return customer;
    }

    @Override
    public List<Kurum> findAll() {
        return null;
    }

    @Override
    public Kurum update(Kurum dto) {
        Kurum customer = null;
        try{
            this.connection.setAutoCommit(false);
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);){
            statement.setString(1, dto.getKurumAdi());
            statement.setString(2, dto.getOwner());
            statement.setString(4, dto.getLogo());
            statement.setLong(9, dto.getId());
            statement.execute();
            this.connection.commit();
            customer = this.findById(dto.getId());
        }catch(SQLException e){
            try{
                this.connection.rollback();
            }catch (SQLException sqle){
                e.printStackTrace();
                throw new RuntimeException(sqle);
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public Kurum create(Kurum dto) {

        try(PreparedStatement statement=this.connection.prepareStatement(INSERT);) {

            statement.setString(1,dto.getKurumAdi());
            statement.setString(2,dto.getOwner());
            statement.setString(3,dto.getLogo());
            statement.execute();
            return  null;


        }catch (SQLException exception){
            exception.printStackTrace();
            throw  new RuntimeException(exception);

        }


    }

    @Override
    public void delete(long id) {

        int i;
        Kurum customer=new Kurum();
        try(PreparedStatement preparedStatement=this.connection.prepareStatement(DELETE);){

            preparedStatement.setLong(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
            throw  new RuntimeException(e);

        }

    }

}

