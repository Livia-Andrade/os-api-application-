/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andrade.OSApiApplication.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;



/**
 *
 * @author Amethyst
 */
public class ProblemaException {

        private Integer status;
        private LocalDateTime dataHora;
        private String titulo;

        private List<CampoProblema> listaCamposProblema;

        public List<CampoProblema> getListaCamposProblema() {
            return listaCamposProblema;
        }

        public void setListaCamposProblema(List<CampoProblema> listaCamposProblema) {
            this.listaCamposProblema = listaCamposProblema;
        }

        public static class CampoProblema {

            private String nomeCampo;
            private String mensagemCampo;

            public CampoProblema(String nomeCampo, String mensagemCampo) {
                this.nomeCampo = nomeCampo;
                this.mensagemCampo = mensagemCampo;
            }

            public String getNomeCampo() {
                return nomeCampo;
            }

            public void setNomeCampo(String nomeCampo) {
                this.nomeCampo = nomeCampo;
            }

            public String getMensagemCampo() {
                return mensagemCampo;
            }

            public void setMensagemCampo(String mensagemCampo) {
                this.mensagemCampo = mensagemCampo;
            }
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public LocalDateTime getDataHora() {
            return dataHora;
        }

        public void setDataHora(LocalDateTime dataHora) {
            this.dataHora = dataHora;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

    }
