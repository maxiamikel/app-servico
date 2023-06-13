package com.maxi.backservico.config;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maxi.backservico.domains.Cliente;
import com.maxi.backservico.domains.Servico;
import com.maxi.backservico.domains.Tecnico;
import com.maxi.backservico.enums.Genero;
import com.maxi.backservico.enums.PrioridadeServico;
import com.maxi.backservico.enums.StatusServico;
import com.maxi.backservico.repositories.ClienteRepository;
import com.maxi.backservico.repositories.ServicoRepository;
import com.maxi.backservico.repositories.TecnicoRepository;

@Configuration
public class DbConfig {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Bean
    public void inicializarDB(){
        Tecnico t1 = new Tecnico(null, "Amikel Maxi", "703.845.972-46", "amikel@gmail.com", Genero.MASCULINO, "TC-904", 10000);
        Tecnico t2 = new Tecnico(null, "Nervil Maxi", "012.824.319-86", "nervil@gmail.com", Genero.MASCULINO, "TC-909", 10200);
        tecnicoRepository.saveAll(Arrays.asList(t1, t2));

        Cliente c1 = new Cliente(null, "Myrlande", "012.824.319-86", "myrlande@maxi.com", Genero.FEMININO);
        clienteRepository.saveAll(Arrays.asList(c1));

        Servico s1 = new Servico(null, "Servico teste", LocalDateTime.now(), 10900, StatusServico.ABERTO, PrioridadeServico.NORMAL, t1, c1);
        Servico s2 = new Servico(null, "Servico teste", LocalDateTime.now(), 10900, StatusServico.ANDAMENTO, PrioridadeServico.NORMAL, t1, c1);
       
        s1.setCliente(c1);
        s1.setTecnico(t1);

        servicoRepository.saveAll(Arrays.asList(s1, s2));
    }
    
}
